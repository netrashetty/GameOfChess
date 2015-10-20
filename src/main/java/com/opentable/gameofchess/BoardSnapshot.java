package com.opentable.gameofchess;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * Created by netra.shetty on 19/10/15.
 */
@ToString
@AllArgsConstructor
public class BoardSnapshot {
    private final Position[][] positions;
}
