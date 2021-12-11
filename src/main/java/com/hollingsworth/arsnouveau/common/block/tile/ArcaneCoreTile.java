package com.hollingsworth.arsnouveau.common.block.tile;

import com.hollingsworth.arsnouveau.client.particle.GlowParticleData;
import com.hollingsworth.arsnouveau.client.particle.ParticleColor;
import com.hollingsworth.arsnouveau.client.particle.ParticleUtil;
import com.hollingsworth.arsnouveau.common.block.ITickable;
import com.hollingsworth.arsnouveau.setup.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ArcaneCoreTile extends ModdedTile implements ITickable {

    public ArcaneCoreTile(BlockPos pos, BlockState state) {
        super(BlockRegistry.ARCANE_CORE_TILE, pos, state);
    }

    @Override
    public void tick() {

        if(level.isClientSide) {
            ParticleColor randColor = new ParticleColor(level.random.nextInt(255), level.random.nextInt(255), level.random.nextInt(255));
            for (int i = 0; i < 2; i++) {
                level.addParticle(
                        GlowParticleData.createData(randColor),
                        worldPosition.getX() + 0.5 + ParticleUtil.inRange(-0.3, 0.3), worldPosition.getY() + 0.5 + ParticleUtil.inRange(-0.3, 0.3), worldPosition.getZ() + 0.5 + ParticleUtil.inRange(-0.3, 0.3),
                        0, 0, 0);
            }
        }
    }
}
