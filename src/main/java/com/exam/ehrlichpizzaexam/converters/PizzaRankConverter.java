/**
 * This is a converter or mapper for Pizza and its Rank
 *
 * @author  Christian Montifar
 * @version 1.0
 * @since   2022-12-02
 */
package com.exam.ehrlichpizzaexam.converters;

import com.exam.ehrlichpizzaexam.model.dto.PizzaRankDTO;

import java.util.*;
import java.util.stream.Collectors;

public class PizzaRankConverter {
    private static List<PizzaRankDTO> rankDTOList = new ArrayList<>();

    public static List<PizzaRankDTO> convertToPizzaRank(Map<String, Integer> rankMap){
        Set<String> keys=rankMap.keySet();
        for(String key:keys){
            rankDTOList.add(new PizzaRankDTO(key,rankMap.get(key)));
        }
        return rankDTOList.stream().sorted(
                        Comparator.comparing((PizzaRankDTO x)->rankMap.get(x.getPizza()))
                                .thenComparing(PizzaRankDTO::getTotalSale).reversed())
                .collect(Collectors.toList());
    }
}
