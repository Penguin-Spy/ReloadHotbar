package ml.cheeseos.reloadhotbar.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.HotbarStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @ModifyReturnValue(method = "getCreativeHotbarStorage", at = @At("TAIL"))
    public HotbarStorage modifyCreativeHotbarStorage(HotbarStorage original) {
        ((HotbarStorageAccessor) original).invokeLoad();
        return original;
    }
}
