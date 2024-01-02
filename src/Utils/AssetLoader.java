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
        BLANK("Images/backgrounds/blankPng.png"),
        TRANSMUTE_BACKGROUND("Images/backgrounds/transmuteBackground.png"),
        START_BACKGROUND("Images/backgrounds/startBackground0.png"),
        DEDUCTION_BACKGROUND("Images/backgrounds/deductionBackground.png");
        
        
        private final String path;
        
        Backgrounds(String path) {
            this.path = path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum ButtonBackgrounds implements AssetPath {
        TABLE_0("Images/buttonBackgrounds/tablesBackground0.png"),
        TABLE_1("Images/buttonBackgrounds/tablesBackground1.png"),
        PUBLISH_0("Images/buttonBackgrounds/publish0.png"),
        PUBLISH_1("Images/buttonBackgrounds/publish1.png"),
        LAB_0("Images/buttonBackgrounds/lab0.png"),
        LAB_1("Images/buttonBackgrounds/lab1.png"),
        JUNGLE_0("Images/buttonBackgrounds/forage0.png"),
        JUNGLE_1("Images/buttonBackgrounds/forage1.png"),
        INVENTORY_0("Images/buttonBackgrounds/inventory0.png"),
        INVENTORY_1("Images/buttonBackgrounds/inventory1.png"),
        TRANS_0("Images/buttonBackgrounds/transmutate0.png"),
        TRANS_1("Images/buttonBackgrounds/transmutate1.png"),
        PAUSE("Images/buttonBackgrounds/pause.png"),
        EU4("Images/buttonBackgrounds/eu4Logo.png");
        
        
        private final String path;
        
        ButtonBackgrounds(String path) {
            this.path = path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum ButtonTexts implements AssetPath {
        DEDUCT("Images/buttonText/deductionText.png"),
        EXPERIMENT("Images/buttonText/experimentText.png"),
        PUBLISH("Images/buttonText/publishText.png"),
        FORAGE("Images/buttonText/forageText.png"),
        TRANSMUTE("Images/buttonText/transmutateText.png"),
        INVENTORY("Images/buttonText/inventoryText.png");
        
        
        private final String path;
        
        ButtonTexts(String path) {
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
        BLUE_NEGATIVE("Images/PotionBrewingViewAssets/bluePotionNegative.png"),
        BLUE_POSITIVE("Images/PotionBrewingViewAssets/bluePotionPositive.png"),
        RED_NEGATIVE("Images/PotionBrewingViewAssets/redPotionNegative.png"),
        RED_POSITIVE("Images/PotionBrewingViewAssets/redPotionPositive.png"),
        GREEN_NEGATIVE("Images/PotionBrewingViewAssets/greenPotionNegative.png"),
        GREEN_POSITIVE("Images/PotionBrewingViewAssets/greenPotionPositive.png"),
        NEUTRAL("Images/PotionBrewingViewAssets/neutralPotion.png"),
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
        RECTANGLE_TABLE("Images/triangleTable/rectangleTable.png"),
        Empty("Images/triangleTable/empty.png");
        
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
        BACKGROUND("Images/ForageGroundsAssets/forageGrounds.png"),
        CARD("Images/ForageGroundsAssets/ingredientCard.png"),
        BACKGROUND1("Images/ForageGroundsAssets/forageBackground1.png"),
        BACKGROUND2("Images/ForageGroundsAssets/forageBackground2.png"),
        BACKGROUND3("Images/ForageGroundsAssets/forageBackground3.png"),
        BACKGROUND4("Images/ForageGroundsAssets/forageBackground4.png"),
        BACKGROUND5("Images/ForageGroundsAssets/forageBackground5.png");
        
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
        BACKGROUND("Images/PotionBrewingViewAssets/PotionBrewingArea.png"),
        new-gui-implementation-and-improvements-stuff
    	  BACKGROUND1("Images/PotionBrewingViewAssets/brewBackground1.png"),
    	  BACKGROUND2("Images/PotionBrewingViewAssets/brewBackground2.png"),
    	  BACKGROUND3("Images/PotionBrewingViewAssets/brewBackground3.png"),
    	  BACKGROUND4("Images/PotionBrewingViewAssets/brewBackground4.png"),
    	  BACKGROUND5("Images/PotionBrewingViewAssets/brewBackground5.png"),
        CAULDRON("Images/PotionBrewingViewAssets/Cauldron.png")
    	;

        
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
        BACKGROUND("Images/PlainViewAssets/PlainViewBackground.png");
        
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
        
        FEATHER("Images/book/feather.png"),
        FEET("Images/book/feet.png"),
        FLOWER("Images/book/flower.png"),
        FROG("Images/book/frog.png"),
        MANDRAKE("Images/book/mandrake.png"),
        MUSHROOM("Images/book/mushroom.png"),
        SCORPION("Images/book/scorpion.png"),
        WEED("Images/book/weed.png");
        
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
        CARD("Images/artifact/artifactCard.png");
        
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
        ALL_POSITIVE("Images/book/C1.png"),
        ALL_NEGATIVE("Images/book/C2.png"),
        NEGATIVE_GREEN("Images/book/C3.png"),
        POSITIVE_RED("Images/book/C4.png"),
        NEGATIVE_BLUE("Images/book/C5.png"),
        NEGATIVE_RED("Images/book/C6.png"),
        POSITIVE_GREEN("Images/book/C7.png"),
        POSITIVE_BLUE("Images/book/C8.png"),
        BOOK("Images/book/book.png"),
        ENVELOPE("Images/book/envelope.png"),
        PUBLISH("Images/book/publish.png"),
        PUBLISHED("Images/book/published.png");
        
        private final String path;
        
        Book(String Path) {
            this.path = Path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum Start implements AssetPath {
        NAME_TEXT("Images/start/alchemistText.png"),
        START_TEXT("Images/start/startText.png"),
        FRAME_GOLD("Images/start/frameGold.png"),
        FRAME_COPPER("Images/start/frameCopper.png"),
        FRAME_WHITE("Images/start/frameWhite.png"),
        FRAME_YELLOW("Images/start/frameYellow.png"),
        GOLD_1("Images/start/goldInt1.png"),
        GOLD_2("Images/start/goldInt2.png"),
        GOLD_3("Images/start/goldInt3.png"),
        GOLD_4("Images/start/goldInt4.png"),
        GOLD_5("Images/start/goldInt5.png");
        
        private final String path;
        
        Start(String Path) {
            this.path = Path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum Gifs implements AssetPath {
        CIRCLE_BLUE("Gifs/Animations/glowCircularBlue.gif"),
        LEAVES("Gifs/Animations/leaves.gif"),
        HOURGLASS("Gifs/Loading/hourglass.gif"),
        POTION("Gifs/Loading/loadingPotion.gif");
        
        private final String path;
        
        Gifs(String path) {
            this.path = path;
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
