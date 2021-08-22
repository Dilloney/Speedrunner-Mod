package com.dilloney.speedrunnermod.mixins.world.structure;

import net.minecraft.structure.NetherFortressGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import static com.dilloney.speedrunnermod.SpeedrunnerMod.OPTIONS;

@Mixin(NetherFortressGenerator.class)
public class NetherFortressGeneratorMixin {

    @Shadow static final NetherFortressGenerator.PieceData[] ALL_BRIDGE_PIECES;
    @Shadow static final NetherFortressGenerator.PieceData[] ALL_CORRIDOR_PIECES;

    static {
        if (OPTIONS.getModDifficulty() <= 2 && OPTIONS.modifiedWorldGeneration) {
            ALL_BRIDGE_PIECES = new NetherFortressGenerator.PieceData[]{new NetherFortressGenerator.PieceData(NetherFortressGenerator.Bridge.class, 10, 1), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgeCrossing.class, 10, 2), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgeSmallCrossing.class, 10, 2), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgeStairs.class, 10, 1), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgePlatform.class, 50, 3), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorExit.class, 5, 1)};
            ALL_CORRIDOR_PIECES = new NetherFortressGenerator.PieceData[]{new NetherFortressGenerator.PieceData(NetherFortressGenerator.SmallCorridor.class, 10, 2, true), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorCrossing.class, 10, 1), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorRightTurn.class, 3, 1), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorLeftTurn.class, 3, 1), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorStairs.class, 10, 2, true), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorBalcony.class, 3, 2), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorNetherWartsRoom.class, 5, 2)};
        } else if (OPTIONS.getModDifficulty() >= 3 && OPTIONS.modifiedWorldGeneration) {
            ALL_BRIDGE_PIECES = new NetherFortressGenerator.PieceData[]{new NetherFortressGenerator.PieceData(NetherFortressGenerator.Bridge.class, 20, 2), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgeCrossing.class, 20, 3), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgeSmallCrossing.class, 10, 3), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgeStairs.class, 15, 2), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgePlatform.class, 25, 2), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorExit.class, 5, 1)};
            ALL_CORRIDOR_PIECES = new NetherFortressGenerator.PieceData[]{new NetherFortressGenerator.PieceData(NetherFortressGenerator.SmallCorridor.class, 20, 2, true), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorCrossing.class, 20, 3), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorRightTurn.class, 5, 4), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorLeftTurn.class, 5, 4), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorStairs.class, 10, 3, true), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorBalcony.class, 5, 2), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorNetherWartsRoom.class, 5, 2)};
        } else {
            ALL_BRIDGE_PIECES = new NetherFortressGenerator.PieceData[]{new NetherFortressGenerator.PieceData(NetherFortressGenerator.Bridge.class, 30, 0, true), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgeCrossing.class, 10, 4), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgeSmallCrossing.class, 10, 4), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgeStairs.class, 10, 3), new NetherFortressGenerator.PieceData(NetherFortressGenerator.BridgePlatform.class, 5, 2), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorExit.class, 5, 1)};
            ALL_CORRIDOR_PIECES = new NetherFortressGenerator.PieceData[]{new NetherFortressGenerator.PieceData(NetherFortressGenerator.SmallCorridor.class, 25, 0, true), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorCrossing.class, 15, 5), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorRightTurn.class, 5, 10), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorLeftTurn.class, 5, 10), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorStairs.class, 10, 3, true), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorBalcony.class, 7, 2), new NetherFortressGenerator.PieceData(NetherFortressGenerator.CorridorNetherWartsRoom.class, 5, 2)};
        }
    }
}