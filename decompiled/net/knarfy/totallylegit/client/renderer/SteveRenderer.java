/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.vertex.PoseStack
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.renderer.entity.EntityRendererProvider$Context
 *  net.minecraft.client.renderer.entity.MobRenderer
 *  net.minecraft.client.renderer.entity.state.LivingEntityRenderState
 *  net.minecraft.resources.ResourceLocation
 *  net.minecraft.world.entity.LivingEntity
 */
package net.knarfy.totallylegit.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.knarfy.totallylegit.client.model.Modelsteve;
import net.knarfy.totallylegit.client.model.animations.steveAnimation;
import net.knarfy.totallylegit.entity.SteveEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class SteveRenderer
extends MobRenderer<SteveEntity, LivingEntityRenderState, Modelsteve> {
    private SteveEntity entity = null;

    public SteveRenderer(EntityRendererProvider.Context context) {
        super(context, (EntityModel)new AnimatedModel(context.bakeLayer(Modelsteve.LAYER_LOCATION)), 0.5f);
    }

    public LivingEntityRenderState createRenderState() {
        return new LivingEntityRenderState();
    }

    public void extractRenderState(SteveEntity entity, LivingEntityRenderState state, float partialTicks) {
        super.extractRenderState((LivingEntity)entity, state, partialTicks);
        this.entity = entity;
        if (this.model instanceof AnimatedModel) {
            ((AnimatedModel)this.model).setEntity(entity);
        }
    }

    public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
        return ResourceLocation.parse((String)"totally_legit:textures/entities/steve.png");
    }

    protected void scale(LivingEntityRenderState state, PoseStack poseStack) {
        poseStack.scale(0.95f, 0.95f, 0.95f);
    }

    private static final class AnimatedModel
    extends Modelsteve {
        private SteveEntity entity = null;

        public AnimatedModel(ModelPart root) {
            super(root);
        }

        public void setEntity(SteveEntity entity) {
            this.entity = entity;
        }

        @Override
        public void setupAnim(LivingEntityRenderState state) {
            this.root().getAllParts().forEach(ModelPart::resetPose);
            this.animateWalk(steveAnimation.walking, state.walkAnimationPos, state.walkAnimationSpeed, 1.0f, 1.5f);
            this.animate(this.entity.animationState1, steveAnimation.give_chicken, state.ageInTicks, 1.0f);
            super.setupAnim(state);
        }
    }
}

