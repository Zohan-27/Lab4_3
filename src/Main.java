import java.util.Scanner;

class Visualization {
    private int width;
    protected int height;
    String backgroundColor;
    public boolean isInteractive;

    public Visualization(int width, int height, String backgroundColor, boolean isInteractive) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.isInteractive = isInteractive;
    }

    public void displayInfo() {
        System.out.println("Visualization Info:");
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Background Color: " + backgroundColor);
        System.out.println("Interactive?: " + isInteractive);
    }

    @Override
    public String toString() {
        return "Visualization Info:\n" +
                "Width: " + width +
                "\nHeight: " + height +
                "\nBackground Color: " + backgroundColor +
                "\nInteractive?: " + isInteractive;
    }
}
class VisualizationFrame extends Visualization {
    private String frameType;
    protected boolean isResizable;
    public int zIndex;

    public VisualizationFrame(int width, int height, String backgroundColor, boolean isInteractive,
                              String frameType, boolean isResizable, int zIndex) {
        super(width, height, backgroundColor, isInteractive);
        this.frameType = frameType;
        this.isResizable = isResizable;
        this.zIndex = zIndex;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Frame Type: " + frameType);
        System.out.println("Resizable?: " + isResizable);
        System.out.println("Z-Index: " + zIndex);
    }

    public void displayInfo(String additionalInfo) {
        displayInfo();
        System.out.println("Additional Info: " + additionalInfo);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nFrame Type: " + frameType +
                "\nResizable?: " + isResizable +
                "\nZ-Index: " + zIndex;
    }
}
class VisualizationLayer extends Visualization {
    private String layerName;
    protected int opacity;
    public boolean isVisible;

    public VisualizationLayer(int width, int height, String backgroundColor, boolean isInteractive,
                              String layerName, int opacity, boolean isVisible) {
        super(width, height, backgroundColor, isInteractive);
        this.layerName = layerName;
        this.opacity = opacity;
        this.isVisible = isVisible;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Layer Name: " + layerName);
        System.out.println("Opacity: " + opacity);
        System.out.println("Visible?: " + isVisible);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLayer Name: " + layerName +
                "\nOpacity: " + opacity +
                "\nVisible?: " + isVisible;
    }
}




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueInput = true;

        while (continueInput) {
            Visualization[] visualizations = new Visualization[3];
            VisualizationFrame[] frames = new VisualizationFrame[3];
            VisualizationLayer[] layers = new VisualizationLayer[3];

            for (int i = 0; i < 3; i++) {
                System.out.println("Enter Visualization " + (i + 1) + " data:");
                System.out.print("Width: ");
                int width = scanner.nextInt();
                System.out.print("Height: ");
                int height = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Background Color: ");
                String backgroundColor = scanner.nextLine();
                System.out.print("Interactive visualization (true/false): ");
                boolean isInteractive = scanner.nextBoolean();

                visualizations[i] = new Visualization(width, height, backgroundColor, isInteractive);

                System.out.println("\nEnter VisualizationFrame " + (i + 1) + " data:");
                System.out.print("Resizable (true/false): ");
                boolean isResizable = scanner.nextBoolean();
                scanner.nextLine();
                System.out.print("Frame Type: ");
                String frameType = scanner.nextLine();
                System.out.print("Z-Index: ");
                int zIndex = scanner.nextInt();

                frames[i] = new VisualizationFrame(width, height, backgroundColor, isInteractive,
                        frameType, isResizable, zIndex);

                System.out.println("\nEnter VisualizationLayer " + (i + 1) + " data:");
                System.out.print("Layer Name: ");
                String layerName = scanner.next();
                System.out.print("Opacity: ");
                int opacity = scanner.nextInt();
                System.out.print("Visible (true/false): ");
                boolean isVisible = scanner.nextBoolean();

                layers[i] = new VisualizationLayer(width, height, backgroundColor, isInteractive,
                        layerName, opacity, isVisible);

                scanner.nextLine();
                System.out.println();

                System.out.println("Do you want to continue entering data? (yes/no)");
                String choice = scanner.next();

                if (choice.equalsIgnoreCase("no")) {
                    continueInput = false;
                    break; // Выход из цикла заполнения данных
                } else if (!choice.equalsIgnoreCase("yes")) {
                    System.out.println("Invalid input. Continuing data entry by default.");
                }
                scanner.nextLine(); // Очистка буфера сканера
            }

            // Вывод информации обо всех введенных объектах
            for (int i = 0; i < 3; i++) {
                if(visualizations[i] == null || frames[i] == null || layers[i] == null) {
                    break;
                }
                System.out.println("\nVisualization " + (i + 1) + " Info:");
                visualizations[i].displayInfo();
                System.out.println("\nVisualizationFrame " + (i + 1) + " Info:");
                frames[i].displayInfo();
                System.out.println("\nVisualizationLayer " + (i + 1) + " Info:");
                layers[i].displayInfo();
            }
        }

        scanner.close();
    }
}

