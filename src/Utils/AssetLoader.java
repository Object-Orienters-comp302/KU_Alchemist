package Utils;

public class AssetLoader {
    // Method to get asset path
    public static String getAssetPath(AssetPath asset) {
        return asset.getPath();
    }
    
    // Enums for asset paths
    public enum Backgrounds implements AssetPath {
        BLUE("resources/Images/backgrounds/blueBackground.png"),
        RED("resources/Images/backgrounds/redBackground.png"),
        GREEN("resources/Images/backgrounds/greenBackground.png"),
        YELLOW("resources/Images/backgrounds/yellowBackground.png"),
        PURPLE("resources/Images/backgrounds/purpleBackground.png"),
        MAIN_BACKGROUND("resources/Images/backgrounds/MainBackground.png"),
        INVENTORY("resources/Images/backgrounds/inventoryBackground.png"),
        PUBLISH("resources/Images/backgrounds/publishBackground.png"),
        BLANK("resources/Images/backgrounds/blankPng.png"),
        TRANSMUTE_BACKGROUND("resources/Images/backgrounds/transmuteBackground.png"),
        START_BACKGROUND("resources/Images/backgrounds/startBackground0.png"),
        DEDUCTION_BACKGROUND("resources/Images/backgrounds/deductionBackground.png");
        
        
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
        TABLE_0("resources/Images/buttonBackgrounds/tablesBackground0.png"),
        TABLE_1("resources/Images/buttonBackgrounds/tablesBackground1.png"),
        PUBLISH_0("resources/Images/buttonBackgrounds/publish0.png"),
        PUBLISH_1("resources/Images/buttonBackgrounds/publish1.png"),
        LAB_0("resources/Images/buttonBackgrounds/lab0.png"),
        LAB_1("resources/Images/buttonBackgrounds/lab1.png"),
        JUNGLE_0("resources/Images/buttonBackgrounds/forage0.png"),
        JUNGLE_1("resources/Images/buttonBackgrounds/forage1.png"),
        INVENTORY_0("resources/Images/buttonBackgrounds/inventory0.png"),
        INVENTORY_1("resources/Images/buttonBackgrounds/inventory1.png"),
        TRANS_0("resources/Images/buttonBackgrounds/transmutate0.png"),
        TRANS_1("resources/Images/buttonBackgrounds/transmutate1.png"),
        PAUSE("resources/Images/buttonBackgrounds/pause.png"),
        EU4("resources/Images/buttonBackgrounds/eu4Logo.png");
        
        
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
        DEDUCT("resources/Images/buttonText/deductionText.png"),
        EXPERIMENT("resources/Images/buttonText/experimentText.png"),
        PUBLISH("resources/Images/buttonText/publishText.png"),
        FORAGE("resources/Images/buttonText/forageText.png"),
        TRANSMUTE("resources/Images/buttonText/transmutateText.png"),
        INVENTORY("resources/Images/buttonText/inventoryText.png"),
        MARKET("resources/Images/buttonText/marketText.png"),
        HOST("resources/Images/buttonText/hostText.png"),
        JOIN("resources/Images/buttonText/joinText.png")
        ;
        
        
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
        GREEN_TICK("resources/Images/tokens/greenTick.png"),
        RED_X("resources/Images/tokens/redX.png"),
        BLUE("resources/Images/tokens/bluePortrait.png"),
        RED("resources/Images/tokens/redPortrait.png"),
        GREEN("resources/Images/tokens/greenPortrait.png"),
        YELLOW("resources/Images/tokens/yellowPortrait.png"),
        PURPLE("resources/Images/tokens/purplePortrait.png");
        
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
        BLUE("resources/Images/avatars/blueAvatar.png"),
        RED("resources/Images/avatars/redAvatar.png"),
        GREEN("resources/Images/avatars/greenAvatar.png"),
        YELLOW("resources/Images/avatars/yellowAvatar.png"),
        PURPLE("resources/Images/avatars/purpleAvatar.png");
        
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
        BLUE_NEGATIVE("resources/Images/PotionBrewingViewAssets/bluePotionNegative.png"),
        BLUE_POSITIVE("resources/Images/PotionBrewingViewAssets/bluePotionPositive.png"),
        RED_NEGATIVE("resources/Images/PotionBrewingViewAssets/redPotionNegative.png"),
        RED_POSITIVE("resources/Images/PotionBrewingViewAssets/redPotionPositive.png"),
        GREEN_NEGATIVE("resources/Images/PotionBrewingViewAssets/greenPotionNegative.png"),
        GREEN_POSITIVE("resources/Images/PotionBrewingViewAssets/greenPotionPositive.png"),
        NEUTRAL("resources/Images/PotionBrewingViewAssets/neutralPotion.png"),
        UNKNOWN("resources/Images/PotionBrewingViewAssets/unknownPotion.png");
        
        
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
        TRIANGLE_TABLE("resources/Images/triangleTable/TriangleTable.png"),
        MINUS_BLUE("resources/Images/triangleTable/minusBlue.png"),
        MINUS_GREEN("resources/Images/triangleTable/minusGreen.png"),
        MINUS_RED("resources/Images/triangleTable/minusRed.png"),
        OUTLINE("resources/Images/triangleTable/outline.png"),
        PLUS_BLUE("resources/Images/triangleTable/plusBlue.png"),
        PLUS_GREEN("resources/Images/triangleTable/plusGreen.png"),
        PLUS_RED("resources/Images/triangleTable/plusRed.png"),
        QUESTION_MARK("resources/Images/triangleTable/questionMark.png"),
        QUESTION_MARK_WHITE("resources/Images/triangleTable/questionMarkWhite.png"),
        RECTANGLE_TABLE("resources/Images/triangleTable/rectangleTable.png"),
        Empty("resources/Images/triangleTable/empty.png");
        
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
        BACKGROUND("resources/Images/ForageGroundsAssets/forageGrounds.png"),
        CARD("resources/Images/ForageGroundsAssets/ingredientCard.png"),
        BACKGROUND1("resources/Images/ForageGroundsAssets/forageBackground1.png"),
        BACKGROUND2("resources/Images/ForageGroundsAssets/forageBackground2.png"),
        BACKGROUND3("resources/Images/ForageGroundsAssets/forageBackground3.png"),
        BACKGROUND4("resources/Images/ForageGroundsAssets/forageBackground4.png"),
        BACKGROUND5("resources/Images/ForageGroundsAssets/forageBackground5.png");
        
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
        BACKGROUND("resources/Images/PotionBrewingViewAssets/PotionBrewingArea.png"),
        
    	  BACKGROUND1("resources/Images/PotionBrewingViewAssets/brewBackground1.png"),
    	  BACKGROUND2("resources/Images/PotionBrewingViewAssets/brewBackground2.png"),
    	  BACKGROUND3("resources/Images/PotionBrewingViewAssets/brewBackground3.png"),
    	  BACKGROUND4("resources/Images/PotionBrewingViewAssets/brewBackground4.png"),
    	  BACKGROUND5("resources/Images/PotionBrewingViewAssets/brewBackground5.png"),
        CAULDRON("resources/Images/PotionBrewingViewAssets/cauldron.png")
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
        BACKGROUND("resources/Images/PlainViewAssets/PlainViewBackground.png");
        
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
        
        FEATHER("resources/Images/book/feather.png"),
        FEET("resources/Images/book/feet.png"),
        FLOWER("resources/Images/book/flower.png"),
        FROG("resources/Images/book/frog.png"),
        MANDRAKE("resources/Images/book/mandrake.png"),
        MUSHROOM("resources/Images/book/mushroom.png"),
        SCORPION("resources/Images/book/scorpion.png"),
        WEED("resources/Images/book/weed.png");
        
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
        CARD("resources/Images/artifact/artifactCard.png"),
        WISDOM("resources/Images/artifact/wisdom6.png"),
        MORTAR("resources/Images/artifact/mortar5.png"),
        PRESS("resources/Images/artifact/press1.png"),
        IDOL("resources/Images/artifact/idol.png"),
        GIANTX("resources/Images/artifact/giantX.png")
        ;
        
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
        ALL_POSITIVE("resources/Images/book/C1.png"),
        ALL_NEGATIVE("resources/Images/book/C2.png"),
        NEGATIVE_GREEN("resources/Images/book/C3.png"),
        POSITIVE_RED("resources/Images/book/C4.png"),
        NEGATIVE_BLUE("resources/Images/book/C5.png"),
        NEGATIVE_RED("resources/Images/book/C6.png"),
        POSITIVE_GREEN("resources/Images/book/C7.png"),
        POSITIVE_BLUE("resources/Images/book/C8.png"),
        BOOK("resources/Images/book/book.png"),
        ENVELOPE("resources/Images/book/envelope.png"),
        PUBLISH("resources/Images/book/publish.png"),
        PUBLISHED("resources/Images/book/published.png");
        
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
        NAME_TEXT("resources/Images/start/alchemistText.png"),
        START_TEXT("resources/Images/start/startText.png"),
        FRAME_GOLD("resources/Images/start/frameGold.png"),
        FRAME_COPPER("resources/Images/start/frameCopper.png"),
        FRAME_WHITE("resources/Images/start/frameWhite.png"),
        FRAME_YELLOW("resources/Images/start/frameYellow.png"),
        GOLD_1("resources/Images/start/goldInt1.png"),
        GOLD_2("resources/Images/start/goldInt2.png"),
        GOLD_3("resources/Images/start/goldInt3.png"),
        GOLD_4("resources/Images/start/goldInt4.png"),
        GOLD_5("resources/Images/start/goldInt5.png");
        
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
        CIRCLE_BLUE("resources/Gifs/Animations/glowCircularBlue.gif"),
        LEAVES("resources/Gifs/Animations/leaves.gif"),
        HOURGLASS("resources/Gifs/Loading/hourglass.gif"),
        POTION("resources/Gifs/Loading/loadingPotion.gif"),
        FIREBALL("resources/Gifs/Animations/orbFire.gif"),
        CONFETTI("resources/Gifs/Animations/confetti.gif")
        
        ;
        
        private final String path;
        
        Gifs(String path) {
            this.path = path;
        }
        
        @Override
        public String getPath() {
            return path;
        }
    }
    
    public enum SoundPlayer implements AssetPath {
        CONTINUEGOLD("resources/Images/sound/continueGold.png"),
        CONTINUEGREEN("resources/Images/sound/continueGold.png"),
        PAUSEGOLD("resources/Images/sound/pauseGold.png"),
        PAUSEGREEN("resources/Images/sound/pauseGreen.png"),
        NOTEGOLD("resources/Images/sound/noteGold.png"),
        NOTEGREEN("resources/Images/sound/noteGreen.png"),
        MINUS("resources/Images/sound/minus.png"),
        PLUS("resources/Images/sound/plus.png"),
        NOTEANTIGOLD("resources/Images/sound/noteAntiGold.png")
        ;
        
        private final String path;
        
        SoundPlayer(String path) {
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
