package ml.cheeseos.reloadhotbar.mixin;

import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.options.HotbarStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(CreativeInventoryScreen.class)
public class CreativeInventoryScreenMixin {

    @ModifyVariable(method="setSelectedTab(Lnet/minecraft/item/ItemGroup;)V", at= @At(value="INVOKE_ASSIGN", target = "Lnet/minecraft/client/MinecraftClient;getCreativeHotbarStorage()Lnet/minecraft/client/options/HotbarStorage;"))
    public HotbarStorage thing(HotbarStorage original) {
        ((HotbarStorageMixin) original).invokeLoad();
        return original;
    }
}
