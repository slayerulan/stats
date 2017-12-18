package com.savik;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoefficientsAnalyzer {

    public static double LOW_VALUE_BORDER = 1.15;
    public static double RISK_BET_LOW_VALUE_BORDER = 2.0;
    public static double MIN_PERCENTAGE = 0.15;
    public static double MAX_PERCENTAGE = 0.85;

    public static PossibleBetResultContainer analyze(CoeffContainer coeffContainer, PossibleBetContainer betContainer) {
        if (coeffContainer.getLeaf() && betContainer.getLeaf()) {
            return handleLeaf(coeffContainer, betContainer);
        } else {
            return handleContainer(coeffContainer, betContainer);
        }
    }

    private static PossibleBetResultContainer handleLeaf(CoeffContainer coeffContainer, PossibleBetContainer betContainer) {
        PossibleBet possibleBet = betContainer.getPossibleBet();
        Coeff coeff = coeffContainer.getCoeff();

        PossibleBetResultContainer possibleBetResultContainer = new PossibleBetResultContainer(betContainer.getType());
        possibleBetResultContainer.setFirstTeamContainer(possibleBet.getFirstTeamContainer());
        possibleBetResultContainer.setSecondTeamContainer(possibleBet.getSecondTeamContainer());
        possibleBetResultContainer.setCoeff(coeff);


        Double firstTeamContainerPercentage = (double) possibleBet.getFirstTeamPercentage() / 100;
        Double secondTeamContainerPercentage = (double) possibleBet.getSecondTeamPercentage() / 100;

        possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.SO_SO);
        possibleBetResultContainer.setFirstTeamPercentage(firstTeamContainerPercentage);
        possibleBetResultContainer.setSecondTeamPercentage(secondTeamContainerPercentage);

        if (coeff.getStatus() == CoeffType.SINGLE) {
            handleSingleCoeff(
                    coeff, possibleBetResultContainer, firstTeamContainerPercentage, secondTeamContainerPercentage);
        } else if (coeff.getStatus() == CoeffType.POSITIVE_NEGATIVE) {
            handlePositiveNegativeCoeff(
                    coeff, possibleBetResultContainer,
                    firstTeamContainerPercentage, secondTeamContainerPercentage
            );
        } else {
            throw new RuntimeException("coeff status is weird: " + coeff.getStatus());
        }

        return possibleBetResultContainer;
    }

    private static void handlePositiveNegativeCoeff(Coeff coeff, PossibleBetResultContainer possibleBetResultContainer,
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
        possibleBetResultContainer.setValueBet(maxValue);


        boolean firstTeamHasGoodPositiveChances = firstTeamContainerPercentage > MAX_PERCENTAGE;
        boolean secondTeamHasGoodPositiveChanges = secondTeamContainerPercentage > MAX_PERCENTAGE;

        boolean firstTeamHasGoodNegativeChances = firstTeamContainerPercentage < MIN_PERCENTAGE;
        boolean secondTeamHasGoodNegativeChanges = secondTeamContainerPercentage < MIN_PERCENTAGE;

        if(firstTeamHasGoodPositiveChances || secondTeamHasGoodPositiveChanges) {
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.PERCENTAGES);
            possibleBetResultContainer.setCoeffType(CoeffType.POSITIVE);
        } else if (firstTeamHasGoodNegativeChances || secondTeamHasGoodNegativeChanges) {
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.PERCENTAGES);
            possibleBetResultContainer.setCoeffType(CoeffType.NEGATIVE);
        }

        if (firstTeamHasGoodPositiveChances && secondTeamHasGoodPositiveChanges &&
                Math.max(firstTeamPositiveResult, secondTeamPositiveResult) > LOW_VALUE_BORDER) {
            possibleBetResultContainer.setValueBet(Math.max(firstTeamPositiveResult, secondTeamPositiveResult));
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            possibleBetResultContainer.setCoeffType(CoeffType.POSITIVE);
        } else if (firstTeamHasGoodPositiveChances && firstTeamPositiveResult > LOW_VALUE_BORDER) {
            possibleBetResultContainer.setValueBet(firstTeamPositiveResult);
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            possibleBetResultContainer.setCoeffType(CoeffType.POSITIVE);
        } else if (secondTeamHasGoodPositiveChanges && secondTeamPositiveResult > LOW_VALUE_BORDER) {
            possibleBetResultContainer.setValueBet(secondTeamPositiveResult);
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            possibleBetResultContainer.setCoeffType(CoeffType.POSITIVE);
        } else if (firstTeamHasGoodNegativeChances && secondTeamHasGoodNegativeChanges &&
                Math.max(firstTeamNegativeResult, secondTeamNegativeResult) > LOW_VALUE_BORDER) {
            possibleBetResultContainer.setValueBet(Math.max(firstTeamNegativeResult, secondTeamNegativeResult));
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            possibleBetResultContainer.setCoeffType(CoeffType.NEGATIVE);
        } else if (firstTeamHasGoodNegativeChances && firstTeamNegativeResult > LOW_VALUE_BORDER) {
            possibleBetResultContainer.setValueBet(firstTeamNegativeResult);
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            possibleBetResultContainer.setCoeffType(CoeffType.NEGATIVE);
        } else if (secondTeamHasGoodNegativeChanges && secondTeamNegativeResult > LOW_VALUE_BORDER) {
            possibleBetResultContainer.setValueBet(secondTeamNegativeResult);
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);
            possibleBetResultContainer.setCoeffType(CoeffType.NEGATIVE);
        } else if (maxValue > LOW_VALUE_BORDER) {
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD);

            if ((maxValue == firstTeamPositiveResult || maxValue == secondTeamPositiveResult) && positiveValue > RISK_BET_LOW_VALUE_BORDER) {
                possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.RISK);
            } else if ((maxValue == firstTeamNegativeResult || maxValue == secondTeamNegativeResult) && negativeValue > RISK_BET_LOW_VALUE_BORDER) {
                possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.RISK);
            }

            if (maxValue == firstTeamPositiveResult || maxValue == secondTeamPositiveResult) {
                possibleBetResultContainer.setCoeffType(CoeffType.POSITIVE);
            } else {
                possibleBetResultContainer.setCoeffType(CoeffType.NEGATIVE);
            }
        }

    }

    private static void handleSingleCoeff(Coeff coeff, PossibleBetResultContainer possibleBetResultContainer, Double firstTeamContainerPercentage, Double secondTeamContainerPercentage) {
        possibleBetResultContainer.setCoeffType(CoeffType.SINGLE);

        Double value = coeff.getValue();
        double firstTeamResult = value * firstTeamContainerPercentage;
        double secondTeamResult = value * secondTeamContainerPercentage;

        if (firstTeamResult > secondTeamResult) {
            possibleBetResultContainer.setValueBet(firstTeamResult);
        } else {
            possibleBetResultContainer.setValueBet(secondTeamResult);
        }

        boolean firstTeamHasGoodChances = firstTeamContainerPercentage < MIN_PERCENTAGE || firstTeamContainerPercentage > MAX_PERCENTAGE;
        boolean secondTeamHasGoodChanges = secondTeamContainerPercentage < MIN_PERCENTAGE || secondTeamContainerPercentage > MAX_PERCENTAGE;

        if(firstTeamHasGoodChances || secondTeamHasGoodChanges) {
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.PERCENTAGES);
        }

        if (firstTeamHasGoodChances && secondTeamHasGoodChanges
                && Math.max(firstTeamResult, secondTeamResult) > LOW_VALUE_BORDER) {

            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);

        } else if (firstTeamHasGoodChances && firstTeamResult > LOW_VALUE_BORDER) {

            possibleBetResultContainer.setValueBet(firstTeamResult);
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);

        } else if (secondTeamHasGoodChanges && secondTeamResult > LOW_VALUE_BORDER) {
            possibleBetResultContainer.setValueBet(secondTeamResult);
            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD_PERCENTAGES);

        } else if (Math.max(firstTeamResult, secondTeamResult) > LOW_VALUE_BORDER) {

            if (value > RISK_BET_LOW_VALUE_BORDER) {
                possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.RISK);
            } else {
                possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD);
            }
        }
    }

    private static PossibleBetResultContainer handleContainer(CoeffContainer coeffContainer, PossibleBetContainer betContainer) {
        List<PossibleBetContainer> possibleBetContainerBlocks = betContainer.getChildrenBetBlocks();
        List<PossibleBetResultContainer> childBlocks = new ArrayList<>();
        for (int i = 0; i < possibleBetContainerBlocks.size(); i++) {
            PossibleBetContainer childPossibleBetContainer = possibleBetContainerBlocks.get(i);
            CoeffContainer childCoeffContainer = coeffContainer.findByTypeInFirstLevel(childPossibleBetContainer.getType());
            if (childCoeffContainer != null) {
                PossibleBetResultContainer childResult = analyze(childCoeffContainer, childPossibleBetContainer);
                childBlocks.add(childResult);
            }
        }

        return new PossibleBetResultContainer(
                childBlocks,
                betContainer.getType()
        );
    }
}
