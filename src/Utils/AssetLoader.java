package Utils;

public class AssetLoader {
    // Method to get asset path
    public static String getAssetPath(AssetPath asset) {
        return asset.getPath();
    }
    
    // Enums for asset paths
    public enum Backgrounds implements AssetPath {
        BLUE("Images/backgrounds/blueBackground.png"),
        RED("Images/backgrounds/redBackground.png"),
        GREEN("Images/backgrounds/greenBackground.png"),
        YELLOW("Images/backgrounds/yellowBackground.png"),
        PURPLE("Images/backgrounds/purpleBackground.png"),
        MAIN_BACKGROUND("Images/backgrounds/MainBackground.png"),
        INVENTORY("Images/backgrounds/inventoryBackground.png"),
        PUBLISH("Images/backgrounds/publishBackground.png"),
        TRANSMUTE_BACKGROUND("Images/backgrounds/transmuteBackground.png");
    	
        
        
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
        RED_X("Images/tokens/redX.png"),
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
    
    public enum Avatars implements AssetPath {
        BLUE("Images/avatars/blueAvatar.png"),
        RED("Images/avatars/redAvatar.png"),
        GREEN("Images/avatars/greenAvatar.png"),
        YELLOW("Images/avatars/yellowAvatar.png"),
        PURPLE("Images/avatars/purpleAvatar.png");
        
        private final String path;
        
        Avatars(String path) {
            this.path = path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum Potions implements AssetPath {
        BLUENEGATIVE("Images/PotionBrewingViewAssets/bluePotionNegative.png"),
        BLUEPOSITIVE("Images/PotionBrewingViewAssets/bluePotionPositive.png"),
        REDNEGATIVE("Images/PotionBrewingViewAssets/redPotionNegative.png"),
        REDPOSITIVE("Images/PotionBrewingViewAssets/redPotionPositive.png"),
        GREENNEGATIVE("Images/PotionBrewingViewAssets/greenPotionNegative.png"),
        GREENPOSITIVE("Images/PotionBrewingViewAssets/greenPotionPositive.png"),
        NETURAL("Images/PotionBrewingViewAssets/neturalPotion.png"),
        UNKNOWN("Images/PotionBrewingViewAssets/unknownPotion.png");
    	
        
        
        private final String path;
        
        Potions(String path) {
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
        Card("Images/ForageGroundsAssets/ingredientCard.png");
        
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
        Background("Images/PotionBrewingViewAssets/PotionBrewingArea.png");
        
        private final String path;
        
        PotionBrewingViewAssets(String Path) {
            this.path = Path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum PlainViewAssets implements AssetPath {
        Background("Images/PlainViewAssets/PlainViewBackground.png");
        
        private final String path;
        
        PlainViewAssets(String Path) {
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
    
    public enum Artifacts implements AssetPath {
        ARTIFACTCARD("Images/artifact/artifactCard.png");
        
        private final String path;
        
        Artifacts(String path) {
            this.path = path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    
    
    public enum Book implements AssetPath {
        allPositive("Images/book/C1.png"),
        allNegative("Images/book/C2.png"),
        negativeGreen("Images/book/C3.png"),
        positiveRed("Images/book/C4.png"),
        negativeBlue("Images/book/C5.png"),
        negativeRed("Images/book/C6.png"),
        positiveGreen("Images/book/C7.png"),
        positiveBlue("Images/book/C8.png");
        
        private final String path;
        
        Book(String Path) {
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
