package com.savik.parser.utils;


import com.savik.CoeffContainer;
import com.savik.CoeffEntry;
import com.savik.ContainerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CoeffTransformer {

    public static List<CoeffEntry> transformBlockToEntryWithoutAverageCoeffs(CoeffContainer coeffBlock, String myscoreCode) {
        List<CoeffEntry> coeffEntries = transformBlockToEntry(coeffBlock, "");
        Iterator<CoeffEntry> iterator = coeffEntries.iterator();
        while (iterator.hasNext()) {
            CoeffEntry coeffEntry = iterator.next();
            if (coeffEntry.getCoeff() == null || coeffEntry.getCoeff().isAverageCoeff()) {
                iterator.remove();
            }
            coeffEntry.setMyscoreCode(myscoreCode);
        }
        return coeffEntries;
    }

    public static List<CoeffEntry> transformBlockToEntry(CoeffContainer coeffBlock, String parentPath) {
        if (coeffBlock.getLeaf()) {
            return Arrays.asList(
                    new CoeffEntry(
                            coeffBlock.getCoeff(),
                            true,
                            String.format("%s.%d", parentPath, coeffBlock.getType().ordinal())
                    )
            );
        } else {
            List<? extends CoeffContainer> childrenBlocks = coeffBlock.getChildrenBlocks();
            List<CoeffEntry> childBlocks = new ArrayList<>();
            String path = parentPath.isEmpty() ? String.valueOf(coeffBlock.getType().ordinal()) :
                    String.format("%s.%d", parentPath, coeffBlock.getType().ordinal());
            childBlocks.add(
                    new CoeffEntry(
                            coeffBlock.getCoeff(), false, path
                    )
            );
            for (CoeffContainer childBlock : childrenBlocks) {
                List<CoeffEntry> coeffEntries = transformBlockToEntry(childBlock, path);
                childBlocks.addAll(coeffEntries);
            }
            return childBlocks;
        }
    }

    public static CoeffContainer transformEntryToBlock(List<CoeffEntry> coeffEntries) {
        CoeffContainer root = new CoeffContainer(new ArrayList<>(), ContainerType.ROOT);
        for (CoeffEntry coeffEntry : coeffEntries) {

            CoeffContainer current = root;
            String path = coeffEntry.getPath();
            List<String> types = Arrays.asList(path.split("\\."));
            for (int i = 1; i < types.size(); i++) {
                String ordinal = types.get(i);
                ContainerType containerType = ContainerType.values()[Integer.valueOf(ordinal)];
                CoeffContainer temp = current.findByTypeInFirstLevel(containerType);
                if (temp == null) {
                    if (i == types.size() - 1) {
                        temp = new CoeffContainer(coeffEntry.getCoeff(), containerType);
                    } else {
                        temp = new CoeffContainer(new ArrayList<>(), containerType);
                    }
                    current.getChildrenBlocks().add(temp);
                }
                current = temp;
            }
        }
        return root;
    }
}
