package sci.smarthome.homework;

/** Interfata care implementeaza comportamentele comune
 * */

public interface SmartDevice {

    double getConsumption(); // returneaza consumul de energie
    void turnOn(); // porneste dispozitivul
    void turnOff(); //opreste dispozitivul
}
