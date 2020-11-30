package io.engi.mechanicaltech.client;

import io.engi.mechanicaltech.entity.ManualCrankBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

import static io.engi.mechanicaltech.MechanicalTech.MODID;

@Environment(EnvType.CLIENT)
public class ManualCrankBlockEntityRenderer extends BlockEntityRenderer<ManualCrankBlockEntity> {
    public ManualCrankBlockEntityRenderer(BlockEntityRenderDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(ManualCrankBlockEntity blockEntity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockPos blockPos = blockEntity.getPos();
		BlockState blockState = blockEntity.getWorld().getBlockState(blockPos);
		BakedModel model = MinecraftClient.getInstance().getBakedModelManager().getModel(new ModelIdentifier(new Identifier(MODID, "manual_crank"), "facing=" + blockState.get(FacingBlock.FACING)));
		RenderLayer renderLayer = RenderLayers.getBlockLayer(blockState);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(renderLayer);
        matrixStack.push();
        matrixStack.translate(0.5D, 0D, 0.5D);
        matrixStack.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(blockEntity.getRotation(tickDelta)));
        matrixStack.translate(-0.5D, 0D, -0.5D);
        MinecraftClient.getInstance().getBlockRenderManager().getModelRenderer().render(blockEntity.getWorld(),
                model, blockState, blockEntity.getPos(), matrixStack, vertexConsumer,
                false, new Random(), blockState.getRenderingSeed(blockPos), overlay);
        matrixStack.pop();
    }
}
