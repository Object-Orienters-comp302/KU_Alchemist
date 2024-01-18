import Utils.AssetLoader;
import Utils.GUtil;
import Utils.KawaseBlur;
import org.junit.jupiter.api.Test;

import java.util.Objects;


public class BlurTest {
    @Test
    public void testBlur() {
        KawaseBlur.applyKawaseBlur(Objects.requireNonNull(
                GUtil.fetchImage(AssetLoader.getAssetPath(AssetLoader.Backgrounds.MAIN_BACKGROUND))), 3, 4);
    }
}
