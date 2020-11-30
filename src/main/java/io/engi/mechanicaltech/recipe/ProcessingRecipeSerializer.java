package io.engi.mechanicaltech.recipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.registry.Registry;

public class ProcessingRecipeSerializer implements RecipeSerializer<ProcessingRecipe> {
	private final int processingTime;

	public ProcessingRecipeSerializer(int processingTime) {
		this.processingTime = processingTime;
	}

	public ProcessingRecipe read(Identifier identifier, JsonObject jsonObject) {
		String string = JsonHelper.getString(jsonObject, "group", "");
		JsonElement jsonElement = JsonHelper.hasArray(jsonObject, "ingredient") ? JsonHelper.getArray(jsonObject, "ingredient") : JsonHelper.getObject(jsonObject, "ingredient");
		Ingredient ingredient = Ingredient.fromJson(jsonElement);
		String resultString = JsonHelper.getString(jsonObject, "result");
		Identifier result = new Identifier(resultString);
		ItemStack itemStack = new ItemStack(Registry.ITEM.getOrEmpty(result).orElseThrow(() ->
			new IllegalStateException("Item: " + resultString + " does not exist")
		));
		int i = JsonHelper.getInt(jsonObject, "time", this.processingTime);
		return new ProcessingRecipe(identifier, string, ingredient, itemStack, i);
	}

	public ProcessingRecipe read(Identifier identifier, PacketByteBuf packetByteBuf) {
		String string = packetByteBuf.readString(32767);
		Ingredient ingredient = Ingredient.fromPacket(packetByteBuf);
		ItemStack itemStack = packetByteBuf.readItemStack();
		int i = packetByteBuf.readVarInt();
		return new ProcessingRecipe(identifier, string, ingredient, itemStack, i);
	}

	public void write(PacketByteBuf packetByteBuf, ProcessingRecipe processingRecipe) {
		packetByteBuf.writeString(processingRecipe.group);
		processingRecipe.input.write(packetByteBuf);
		packetByteBuf.writeItemStack(processingRecipe.output);
		packetByteBuf.writeVarInt(processingRecipe.processingTime);
	}
}
