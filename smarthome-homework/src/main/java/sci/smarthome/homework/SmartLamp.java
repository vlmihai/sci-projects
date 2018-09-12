package sci.smarthome.homework;

/** Clasa SmartLamp extinde clasa abstracta si implementeaza interfata.
 *  Comportamentele specifice sunt: schimbarea culorii si a luminozitatii.
 */

public class SmartLamp extends HostDevice {
    private String color;
    private double Brightness;

    /**
     * Consumul este in functie de status si de intensitate
     */

    public double getConsumption() {
        double electricityConsumption;
        if (status && Brightness != 0) {
            electricityConsumption = (defaultConsumption + 2) + (Brightness / 100);
        } else if (status) {
            electricityConsumption = defaultConsumption + 2;
        } else {
            electricityConsumption = defaultConsumption;
        }
        return electricityConsumption;
    }

    double getBrightness() {
        return Brightness;
    }

    /**
     * Metoda pentru reglarea intensitatii luminii
     * Minim 0, maxim 100
     *
     * @param brightnessValue = intensitatea lampii
     */
    void setBrightness(int brightnessValue) {
        if (status && brightnessValue < 0) {
            Brightness = 0;
        } else if (status && brightnessValue > 100) {
            Brightness = 100;
        } else {
            Brightness = brightnessValue;
        }
    }

    String getColor() {
        return color;
    }

    /** Metoda pentru setarea culorii
     * @param color = culoarea lampii
     */
    void setColor(String color) {
        if (status) {
            this.color = color;
        }
    }
}
