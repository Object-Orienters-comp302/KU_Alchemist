package Utils;

public class AssetLoader {
    // Method to get asset path
    public static String getAssetPath(AssetPath asset) {
        return asset.getPath();
    }
    
    // Enums for asset paths
    public enum Backgrounds implements AssetPath {
        KHORNE("Images/backgrounds/khorne_background.png"),
        NURGLE("Images/backgrounds/nurgle_background.png"),
        SLAANESH("Images/backgrounds/slaanesh_background.png"),
        TZEENTCH("Images/backgrounds/tzeentch_background.png"),
        BLUE("Images/backgrounds/blueBackground.png"),
        RED("Images/backgrounds/redBackground.png"),
        GREEN("Images/backgrounds/greenBackground.png"),
        YELLOW("Images/backgrounds/yellowBackground.png"),
        PURPLE("Images/backgrounds/purpleBackground.png");
        
        private final String path;
        
        Backgrounds(String path) {
            this.path = path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum Tokens implements AssetPath {
        GREEN_TICK("Images/tokens/greenTick.png"),
        KHORNE("Images/tokens/khorne.png"),
        NURGLE("Images/tokens/nurgle.png"),
        RED_X("Images/tokens/redX.png"),
        SLAANESH("Images/tokens/slaanesh.png"),
        TZEENTCH("Images/tokens/tzeentch.png"),
        BLUE("Images/tokens/bluePortrait.png"),
        RED("Images/tokens/redPortrait.png"),
        GREEN("Images/tokens/greenPortrait.png"),
        YELLOW("Images/tokens/yellowPortrait.png"),
        PURPLE("Images/tokens/purplePortrait.png");
        
        private final String path;
        
        Tokens(String path) {
            this.path = path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum TriangleTable implements AssetPath {
        TRIANGLE_TABLE("Images/triangleTable/TriangleTable.png"),
        MINUS_BLUE("Images/triangleTable/minusBlue.png"),
        MINUS_GREEN("Images/triangleTable/minusGreen.png"),
        MINUS_RED("Images/triangleTable/minusRed.png"),
        OUTLINE("Images/triangleTable/outline.png"),
        PLUS_BLUE("Images/triangleTable/plusBlue.png"),
        PLUS_GREEN("Images/triangleTable/plusGreen.png"),
        PLUS_RED("Images/triangleTable/plusRed.png"),
        QUESTION_MARK("Images/triangleTable/questionMark.png"),
        QUESTION_MARK_WHITE("Images/triangleTable/questionMarkWhite.png"),
        RECTANGLE_TABLE("Images/triangleTable/rectangleTable.png");
        
        private final String path;
        
        TriangleTable(String path) {
            this.path = path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum ForageGroundsAssets implements AssetPath {
        Background("Images/ForageGroundsAssets/forageGrounds.png"),
        Card("Images/ForageGroundsAssets/CardSized.png");
        
        private final String path;
        
        ForageGroundsAssets(String Path) {
            this.path = Path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    public enum PotionBrewingViewAssets implements AssetPath {
        Background("Images/ForageGroundsAssets/forageGrounds.png");
        
        private final String path;
        
        PotionBrewingViewAssets(String Path) {
            this.path = Path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum IngredientAssets implements AssetPath {
    	
        Feather("Images/book/feather.png"),
        Feet("Images/book/feet.png"),
        Flower("Images/book/flower.png"),
        Frog("Images/book/frog.png"),
        Mandrake("Images/book/mandrake.png"),
        Mushroom("Images/book/mushroom.png"),
        Scorpion("Images/book/scorpion.png"),
        Weed("Images/book/weed.png");
        
        private final String path;
        
        IngredientAssets(String Path) {
            this.path = Path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    
    
    
    // Interface for asset paths
    public interface AssetPath {
        String getPath();
    }
}
