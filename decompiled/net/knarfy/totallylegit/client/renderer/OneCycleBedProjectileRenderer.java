/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  com.mojang.blaze3d.vertex.VertexConsumer
 *  com.mojang.math.Axis
 *  net.minecraft.client.renderer.MultiBufferSource
 *  net.minecraft.client.renderer.RenderType
 *  net.minecraft.client.renderer.entity.EntityRenderer
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.state.EntityRenderState
 *  net.minecraft.client.renderer.entity.state.LivingEntityRenderState
 *  net.minecraft.client.renderer.texture.OverlayTexture
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.Entity
 */
package net.knarfy.totallylegit.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.knarfy.totallylegit.client.model.Modelbed_projectile;
import net.knarfy.totallylegit.entity.OneCycleBedProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class OneCycleBedProjectileRenderer
extends EntityRenderer<OneCycleBedProjectileEntity, LivingEntityRenderState> {
    private static final ResourceLocation texture = ResourceLocation.parse((String)"totally_legit:textures/entities/one_cycle_bed_texture.png");
    private final Modelbed_projectile model;

    public OneCycleBedProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new Modelbed_projectile(context.bakeLayer(Modelbed_projectile.LAYER_LOCATION));
    }

    public void render(LivingEntityRenderState state, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
        VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout((ResourceLocation)texture));
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(state.yRot - 90.0f));
        poseStack.mulPose(Axis.ZP.rotationDegrees(90.0f + state.xRot));
        this.model.setupAnim(state);
        this.model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render((EntityRenderState)state, poseStack, bufferIn, packedLightIn);
    }

    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    public void extractRenderState(OneCycleBedProjectileEntity entity, LivingEntityRenderState state, float partialTicks) {
        super.extractRenderState((Entity)entity, (EntityRenderState)state, partialTicks);
        state.xRot = entity.getXRot(partialTicks);
        state.yRot = entity.getYRot(partialTicks);
    }
}

