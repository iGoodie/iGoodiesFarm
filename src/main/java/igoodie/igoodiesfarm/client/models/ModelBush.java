package igoodie.igoodiesfarm.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBush extends ModelBase
{
	//fields
	ModelRenderer shapeBush;

	public ModelBush()
	{
		textureWidth = 64;
		textureHeight = 32;

		shapeBush = new ModelRenderer(this, 0, 0);
		shapeBush.addBox(0F, 0F, 0F, 16, 16, 16);
		shapeBush.setRotationPoint(-8F, 8F, -8F);
		shapeBush.setTextureSize(64, 32);
		shapeBush.mirror = true;
		setRotation(shapeBush, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		int meta =  entity.worldObj.getBlockMetadata(entity.serverPosX, entity.serverPosY, entity.serverPosZ);

		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		shapeBush.render(f5);
	}

	public void renderModel(float f, int meta)
	{
		switch(meta)
		{
		case 0:
			shapeBush = new ModelRenderer(this, 0, 0);
			shapeBush.addBox(0F, 0F, 0F, 4, 4, 4);
			shapeBush.setRotationPoint(-2F, 20F, -2F);
			shapeBush.setTextureSize(64, 32);
			shapeBush.mirror = true;
			setRotation(shapeBush, 0F, 0F, 0F);
			break;
		case 1:
			shapeBush = new ModelRenderer(this, 0, 0);
			shapeBush.addBox(0F, 0F, 0F, 6, 6, 6);
			shapeBush.setRotationPoint(-3F, 18F, -3F);
			shapeBush.setTextureSize(64, 32);
			shapeBush.mirror = true;
			setRotation(shapeBush, 0F, 0F, 0F);
			break;
		case 2:
			shapeBush = new ModelRenderer(this, 0, 0);
			shapeBush.addBox(0F, 0F, 0F, 8, 8, 8);
			shapeBush.setRotationPoint(-4F, 16F, -4F);
			shapeBush.setTextureSize(64, 32);
			shapeBush.mirror = true;
			setRotation(shapeBush, 0F, 0F, 0F);
			break;
		case 3:
			shapeBush = new ModelRenderer(this, 0, 0);
			shapeBush.addBox(0F, 0F, 0F, 10, 10, 10);
			shapeBush.setRotationPoint(-5F, 14F, -5F);
			shapeBush.setTextureSize(64, 32);
			shapeBush.mirror = true;
			setRotation(shapeBush, 0F, 0F, 0F);
			break;
		case 4:
			shapeBush = new ModelRenderer(this, 0, 0);
			shapeBush.addBox(0F, 0F, 0F, 12, 12, 12);
			shapeBush.setRotationPoint(-6F, 12F, -6F);
			shapeBush.setTextureSize(64, 32);
			shapeBush.mirror = true;
			setRotation(shapeBush, 0F, 0F, 0F);
			break;
		case 5:
			shapeBush = new ModelRenderer(this, 0, 0);
			shapeBush.addBox(0F, 0F, 0F, 14, 14, 14);
			shapeBush.setRotationPoint(-7F, 10F, -7F);
			shapeBush.setTextureSize(64, 32);
			shapeBush.mirror = true;
			setRotation(shapeBush, 0F, 0F, 0F);
			break;
		case 6:
			shapeBush = new ModelRenderer(this, 0, 0);
			shapeBush.addBox(0F, 0F, 0F, 16, 16, 16);
			shapeBush.setRotationPoint(-8F, 8F, -8F);
			shapeBush.setTextureSize(64, 32);
			shapeBush.mirror = true;
			setRotation(shapeBush, 0F, 0F, 0F);
			break;
		case 7:
			shapeBush = new ModelRenderer(this, 0, 0);
			shapeBush.addBox(0F, 0F, 0F, 16, 16, 16);
			shapeBush.setRotationPoint(-8F, 8F, -8F);
			shapeBush.setTextureSize(64, 32);
			shapeBush.mirror = true;
			setRotation(shapeBush, 0F, 0F, 0F);
			break;
		}
		shapeBush.render(f);
	}

	public void renderModel(float f) 
	{
		shapeBush.render(f);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}