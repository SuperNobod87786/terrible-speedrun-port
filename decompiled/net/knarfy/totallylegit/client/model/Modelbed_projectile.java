/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.model.EntityModel
 *  net.minecraft.client.model.geom.ModelLayerLocation
 *  net.minecraft.client.model.geom.ModelPart
 *  net.minecraft.client.model.geom.PartPose
 *  net.minecraft.client.model.geom.builders.CubeDeformation
 *  net.minecraft.client.model.geom.builders.CubeListBuilder
 *  net.minecraft.client.model.geom.builders.LayerDefinition
 *  net.minecraft.client.model.geom.builders.MeshDefinition
 *  net.minecraft.client.model.geom.builders.PartDefinition
 *  net.minecraft.client.renderer.entity.state.LivingEntityRenderState
 *  net.minecraft.resources.ResourceLocation
 */
package net.knarfy.totallylegit.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

public class Modelbed_projectile
extends EntityModel<LivingEntityRenderState> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath((String)"totally_legit", (String)"modelbed_projectile"), "main");
    public final ModelPart leg3;

    public Modelbed_projectile(ModelPart root) {
        super(root);
        this.leg3 = root.getChild("leg3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition leg3 = partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(50, 0).addBox(-8.0f, -3.0f, -16.0f, 3.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-5.0f, (float)16.0f, (float)0.0f, (float)1.5708f, (float)-1.5621f, (float)0.0f));
        PartDefinition leg2_r1 = leg3.addOrReplaceChild("leg2_r1", CubeListBuilder.create().texOffs(50, 18).addBox(-24.0f, -3.0f, 16.0f, 3.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-16.0f, (float)0.0f, (float)32.0f, (float)-3.1416f, (float)0.0f, (float)3.1416f));
        PartDefinition leg1_r1 = leg3.addOrReplaceChild("leg1_r1", CubeListBuilder.create().texOffs(50, 6).addBox(-8.0f, -3.0f, 16.0f, 3.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-24.0f, (float)0.0f, (float)8.0f, (float)0.0f, (float)1.5708f, (float)0.0f));
        PartDefinition foot_r1 = leg3.addOrReplaceChild("foot_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-8.0f, -9.0f, 0.0f, 16.0f, 16.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-9.0f, (float)-9.0f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition head_r1 = leg3.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0f, -9.0f, 16.0f, 16.0f, 16.0f, 6.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)0.0f, (float)-25.0f, (float)7.0f, (float)-1.5708f, (float)0.0f, (float)0.0f));
        PartDefinition leg4_r1 = leg3.addOrReplaceChild("leg4_r1", CubeListBuilder.create().texOffs(50, 12).addBox(-24.0f, -3.0f, -16.0f, 3.0f, 3.0f, 3.0f, new CubeDeformation(0.0f)), PartPose.offsetAndRotation((float)-8.0f, (float)0.0f, (float)8.0f, (float)0.0f, (float)-1.5708f, (float)0.0f));
        return LayerDefinition.create((MeshDefinition)meshdefinition, (int)64, (int)64);
    }

    public void setupAnim(LivingEntityRenderState state) {
        float limbSwing = state.walkAnimationPos;
        float limbSwingAmount = state.walkAnimationSpeed;
        float ageInTicks = state.ageInTicks;
        float netHeadYaw = state.yRot;
        float headPitch = state.xRot;
    }
}

