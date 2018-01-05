package com.savik;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoefficientsAnalyzer {

    public static double LOW_VALUE_BORDER = 1.15;
    public static double RISK_BET_LOW_VALUE_BORDER = 2.0;
    public static double MIN_PERCENTAGE = 0.15;
    public static double MAX_PERCENTAGE = 0.85;

    public static ProposedBetsContainer analyze(CoeffContainer coeffContainer, PossibleBetContainer betContainer) {
        if (coeffContainer.getLeaf() && betContainer.getLeaf()) {
            return handleLeaf(coeffContainer, betContainer);
        } else {
            return handleContainer(coeffContainer, betContainer);
        }
    }

    private static ProposedBetsContainer handleLeaf(CoeffContainer coeffContainer, PossibleBetContainer betContainer) {
        PossibleBet possibleBet = betContainer.getPossibleBet();
        Coeff coeff = coeffContainer.getCoeff();

        ProposedBetsContainer proposedBetsContainer = new ProposedBetsContainer(betContainer.getType());
        proposedBetsContainer.setFirstTeamContainer(possibleBet.getFirstTeamContainer());
        proposedBetsContainer.setSecondTeamContainer(possibleBet.getSecondTeamContainer());
        proposedBetsContainer.setCoeff(coeff);


        Double firstTeamContainerPercentage = (double) possibleBet.getFirstTeamPercentage() / 100;
        Double secondTeamContainerPercentage = (double) possibleBet.getSecondTeamPercentage() / 100;

        proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.SO_SO);
        proposedBetsContainer.setFirstTeamPercentage(firstTeamContainerPercentage);
        proposedBetsContainer.setSecondTeamPercentage(secondTeamContainerPercentage);

        if (coeff.getStatus() == CoeffType.SINGLE) {
            handleSingleCoeff(
                    coeff, proposedBetsContainer, firstTeamContainerPercentage, secondTeamContainerPercentage);
        } else if (coeff.getStatus() == CoeffType.POSITIVE_NEGATIVE) {
            handlePositiveNegativeCoeff(
                    coeff, proposedBetsContainer,
                    firstTeamContainerPercentage, secondTeamContainerPercentage
            );
        } else {
            throw new RuntimeException("coeff status is weird: " + coeff.getStatus());
        }

        return proposedBetsContainer;
    }

    private static void handlePositiveNegativeCoeff(Coeff coeff, ProposedBetsContainer proposedBetsContainer,
                                                    Double firstTeamContainerPercentage, Double secondTeamContainerPercentage) {
        Double positiveValue = coeff.getPositiveValue();
        double firstTeamPositiveResult = positiveValue * firstTeamContainerPercentage;
        double secondTeamPositiveResult = positiveValue * secondTeamContainerPercentage;


        Double negativeValue = coeff.getNegativeValue();
        double firstTeamNegativeResult = negativeValue * (1 - firstTeamContainerPercentage);
        double secondTeamNegativeResult = negativeValue * (1 - secondTeamContainerPercentage);

        double[] values = {firstTeamPositiveResult, secondTeamPositiveResult,
                firstTeamNegativeResult, secondTeamNegativeResult};

        double maxValue = Arrays.stream(values).max().getAsDouble();
        proposedBetsContainer.setValueBet(maxValue);


        boolean firstTeamHasGoodPositiveChances = firstTeamContainerPercentage > MAX_PERCENTAGE;
        boolean secondTeamHasGoodPositiveChanges = secondTeamContainerPercentage > MAX_PERCENTAGE;

        boolean firstTeamHasGoodNegativeChances = firstTeamContainerPercentage < MIN_PERCENTAGE;
        boolean secondTeamHasGoodNegativeChanges = secondTeamContainerPercentage < MIN_PERCENTAGE;

        if (firstTeamHasGoodPositiveChances || secondTeamHasGoodPositiveChanges) {
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.PERCENTAGES);
            proposedBetsContainer.setCoeffType(CoeffType.POSITIVE);
        } else if (firstTeamHasGoodNegativeChances || secondTeamHasGoodNegativeChanges) {
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.PERCENTAGES);
            proposedBetsContainer.setCoeffType(CoeffType.NEGATIVE);
        }

        if (firstTeamHasGoodPositiveChances && secondTeamHasGoodPositiveChanges &&
                Math.max(firstTeamPositiveResult, secondTeamPositiveResult) >= LOW_VALUE_BORDER) {
            proposedBetsContainer.setValueBet(Math.max(firstTeamPositiveResult, secondTeamPositiveResult));
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            proposedBetsContainer.setCoeffType(CoeffType.POSITIVE);
        } else if (firstTeamHasGoodPositiveChances && firstTeamPositiveResult >= LOW_VALUE_BORDER) {
            proposedBetsContainer.setValueBet(firstTeamPositiveResult);
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            proposedBetsContainer.setCoeffType(CoeffType.POSITIVE);
        } else if (secondTeamHasGoodPositiveChanges && secondTeamPositiveResult >= LOW_VALUE_BORDER) {
            proposedBetsContainer.setValueBet(secondTeamPositiveResult);
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            proposedBetsContainer.setCoeffType(CoeffType.POSITIVE);
        } else if (firstTeamHasGoodNegativeChances && secondTeamHasGoodNegativeChanges &&
                Math.max(firstTeamNegativeResult, secondTeamNegativeResult) >= LOW_VALUE_BORDER) {
            proposedBetsContainer.setValueBet(Math.max(firstTeamNegativeResult, secondTeamNegativeResult));
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            proposedBetsContainer.setCoeffType(CoeffType.NEGATIVE);
        } else if (firstTeamHasGoodNegativeChances && firstTeamNegativeResult >= LOW_VALUE_BORDER) {
            proposedBetsContainer.setValueBet(firstTeamNegativeResult);
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            proposedBetsContainer.setCoeffType(CoeffType.NEGATIVE);
        } else if (secondTeamHasGoodNegativeChanges && secondTeamNegativeResult >= LOW_VALUE_BORDER) {
            proposedBetsContainer.setValueBet(secondTeamNegativeResult);
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            proposedBetsContainer.setCoeffType(CoeffType.NEGATIVE);
        } else if (maxValue >= LOW_VALUE_BORDER) {
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD);

            if ((maxValue == firstTeamPositiveResult || maxValue == secondTeamPositiveResult) && positiveValue > RISK_BET_LOW_VALUE_BORDER) {
                proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.RISK);
            } else if ((maxValue == firstTeamNegativeResult || maxValue == secondTeamNegativeResult) && negativeValue > RISK_BET_LOW_VALUE_BORDER) {
                proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.RISK);
            }

            if (maxValue == firstTeamPositiveResult || maxValue == secondTeamPositiveResult) {
                proposedBetsContainer.setCoeffType(CoeffType.POSITIVE);
            } else {
                proposedBetsContainer.setCoeffType(CoeffType.NEGATIVE);
            }
        }

    }

    private static void handleSingleCoeff(Coeff coeff, ProposedBetsContainer proposedBetsContainer, Double firstTeamContainerPercentage, Double secondTeamContainerPercentage) {
        proposedBetsContainer.setCoeffType(CoeffType.SINGLE);

        Double value = coeff.getValue();
        double firstTeamResult = value * firstTeamContainerPercentage;
        double secondTeamResult = value * secondTeamContainerPercentage;

        if (firstTeamResult > secondTeamResult) {
            proposedBetsContainer.setValueBet(firstTeamResult);
        } else {
            proposedBetsContainer.setValueBet(secondTeamResult);
        }

        boolean firstTeamHasGoodChances = firstTeamContainerPercentage < MIN_PERCENTAGE || firstTeamContainerPercentage > MAX_PERCENTAGE;
        boolean secondTeamHasGoodChanges = secondTeamContainerPercentage < MIN_PERCENTAGE || secondTeamContainerPercentage > MAX_PERCENTAGE;

        if (firstTeamHasGoodChances || secondTeamHasGoodChanges) {
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.PERCENTAGES);
        }

        if (firstTeamHasGoodChances && secondTeamHasGoodChanges
                && Math.max(firstTeamResult, secondTeamResult) >= LOW_VALUE_BORDER) {

            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);

        } else if (firstTeamHasGoodChances && firstTeamResult >= LOW_VALUE_BORDER) {

            proposedBetsContainer.setValueBet(firstTeamResult);
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);

        } else if (secondTeamHasGoodChanges && secondTeamResult >= LOW_VALUE_BORDER) {
            proposedBetsContainer.setValueBet(secondTeamResult);
            proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);

        } else if (Math.max(firstTeamResult, secondTeamResult) >= LOW_VALUE_BORDER) {

            if (value > RISK_BET_LOW_VALUE_BORDER) {
                proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.RISK);
            } else {
                proposedBetsContainer.setPossibleBetStatus(PossibleBetStatus.GOOD);
            }
        }
    }

    private static ProposedBetsContainer handleContainer(CoeffContainer coeffContainer, PossibleBetContainer betContainer) {
        List<PossibleBetContainer> possibleBetContainerBlocks = betContainer.getChildrenBetBlocks();
        List<ProposedBetsContainer> childBlocks = new ArrayList<>();
        for (int i = 0; i < possibleBetContainerBlocks.size(); i++) {
            PossibleBetContainer childPossibleBetContainer = possibleBetContainerBlocks.get(i);
            CoeffContainer childCoeffContainer = coeffContainer.findByTypeInFirstLevel(childPossibleBetContainer.getType());
            if (childCoeffContainer != null) {
                ProposedBetsContainer childResult = analyze(childCoeffContainer, childPossibleBetContainer);
                childBlocks.add(childResult);
            }
        }

        return new ProposedBetsContainer(
                childBlocks,
                betContainer.getType()
        );
    }

    public static boolean clearExceptGoodBets(ProposedBetsContainer betContainer) {
        if (betContainer.getLeaf()) {
            PossibleBetStatus possibleBetStatus = betContainer.getPossibleBetStatus();
            return possibleBetStatus == PossibleBetStatus.GOOD || possibleBetStatus == PossibleBetStatus.PERCENTAGES
                    || possibleBetStatus == PossibleBetStatus.GOOD_PERCENTAGES;
        } else {
            betContainer.getChildrenBlocks().removeIf(child -> !clearExceptGoodBets(child));
            return !betContainer.getChildrenBlocks().isEmpty();
        }

    }
}
