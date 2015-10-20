package com.opentable.gameofchess;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by netra.shetty on 19/10/15.
 */
@Getter
@Setter
@AllArgsConstructor
public class Player {
    private Colour playerType;
    private double score; //score of the Player
}
