package com.savik;


import java.util.ArrayList;
import java.util.List;

public class CoefficientsAnalyzer {

    public static PossibleBetResultContainer analyze(CoeffContainer coeffContainer, PossibleBetContainer betContainer) {
        if (coeffContainer.getLeaf() && betContainer.getLeaf()) {
            PossibleBet possibleBet = betContainer.getPossibleBet();
            Coeff coeff = coeffContainer.getCoeff();

            PossibleBetResultContainer possibleBetResultContainer = new PossibleBetResultContainer(betContainer.getType());
            possibleBetResultContainer.setFirstTeamContainer(possibleBet.getFirstTeamContainer());
            possibleBetResultContainer.setSecondTeamContainer(possibleBet.getSecondTeamContainer());
            possibleBetResultContainer.setCoeff(coeff);


            Integer firstTeamContainerPercentage = possibleBet.getFirstTeamPercentage();
            Integer secondTeamContainerPercentage = possibleBet.getSecondTeamPercentage();
            double averagePercentage = (double) (firstTeamContainerPercentage + secondTeamContainerPercentage) / 200;

            possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.SO_SO);
            if (coeff.getStatus() == CoeffType.SINGLE) {
                Double value = coeff.getValue();
                double result = value * averagePercentage;
                possibleBetResultContainer.setValueBet(result);
                if (result > 1) {
                    possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD);
                    possibleBetResultContainer.setCoeffType(CoeffType.SINGLE);
                }
            } else if (coeff.getStatus() == CoeffType.POSITIVE_NEGATIVE) {
                Double positiveValue = coeff.getPositiveValue();
                double positiveResult = positiveValue * averagePercentage;

                Double negativeValue = coeff.getNegativeValue();
                double negativeResult = negativeValue * (1 - averagePercentage);

                if(positiveResult > 1 || negativeResult > 1) {
                    if(positiveResult > negativeResult) {
                        possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD);
                        possibleBetResultContainer.setCoeffType(CoeffType.POSITIVE);
                        possibleBetResultContainer.setValueBet(positiveResult);
                    } else {
                        possibleBetResultContainer.setPossibleBetStatus(PossibleBetStatus.GOOD);
                        possibleBetResultContainer.setCoeffType(CoeffType.NEGATIVE);
                        possibleBetResultContainer.setValueBet(negativeResult);
                    }
                }
            }

            return possibleBetResultContainer;

        } else {
            List<? extends CoeffContainer> coeffContainerChildrenBlocks = coeffContainer.getChildrenBlocks();
            List<PossibleBetContainer> possibleBetContainerBlocks = betContainer.getChildrenBetBlocks();
            // TODO: remove
            /*if (coeffContainerChildrenBlocks.size() != possibleBetContainerBlocks.size()) {
                throw new IllegalArgumentException("coeffContainer is incompatible with betContainer");
            }*/
            List<PossibleBetResultContainer> childBlocks = new ArrayList<>();
            for (int i = 0; i < coeffContainerChildrenBlocks.size(); i++) {
                PossibleBetContainer childPossibleBetContainer = possibleBetContainerBlocks.get(i);
                CoeffContainer childCoeffContainer = coeffContainerChildrenBlocks.get(i);
                if (childPossibleBetContainer.getType() != childCoeffContainer.getType()) {
                    throw new IllegalArgumentException("childPossibleBetContainer type = " + childPossibleBetContainer.getType() + "," +
                            " childCoeffContainer type = " + childCoeffContainer.getType());
                }
                PossibleBetResultContainer childResult = analyze(childCoeffContainer, childPossibleBetContainer);
                childBlocks.add(childResult);
            }

            return new PossibleBetResultContainer(
                    childBlocks,
                    betContainer.getType()
            );

        }
    }
}
