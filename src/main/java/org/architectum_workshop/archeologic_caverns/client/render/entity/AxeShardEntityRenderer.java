package org.architectum_workshop.archeologic_caverns.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.architectum_workshop.archeologic_caverns.client.render.renderstate.entity.AxeShardRenderState;
import org.architectum_workshop.archeologic_caverns.common.entity.AxeShardEntity;


public class AxeShardEntityRenderer extends EntityRenderer<AxeShardEntity, AxeShardRenderState> {
    public AxeShardEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void submit(AxeShardRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        super.submit(state, poseStack, submitNodeCollector, camera);
        submitNameDisplay(state, poseStack, submitNodeCollector, camera, 0);
    }

    @Override
    public AxeShardRenderState createRenderState() {
        return new AxeShardRenderState();
    }

    @Override
    public void extractRenderState(AxeShardEntity entity, AxeShardRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    }
}
