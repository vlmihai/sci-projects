package sci.smarthome.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<HostDevice> devices = new ArrayList<>();
        devices.add(new SmartLamp());
        devices.add(new SmartThermostat());
        devices.add(new SmartSecurityCamera());

        for (HostDevice device : devices) {
            if (device instanceof SmartLamp) {
                SmartLamp bedroomLamp = (SmartLamp) device;
                System.out.println("Bedroom Lamp Status:");
                bedroomLamp.turnOff();
                bedroomLamp.setBrightness(75);
                bedroomLamp.setColor("red");
                bedroomLamp.getConsumption();
                System.out.println("The device is: " + bedroomLamp.status +
                        "\nBrightness is: " + bedroomLamp.getBrightness() +
                        "\nColor is: " + bedroomLamp.getColor() +
                        "\nEnergyConsumption is: " + bedroomLamp.getConsumption());
            }
        }

        for (HostDevice device : devices) {
            if (device instanceof SmartThermostat) {
                SmartThermostat homeThermostat = (SmartThermostat) device;
                System.out.println("\nHome Thermostat Status:");
                homeThermostat.turnOn();
                homeThermostat.getConsumption();
                homeThermostat.setTemperature(22);
                System.out.println("The device is: " + homeThermostat.status +
                        "\nTemperature is set on: " + homeThermostat.getTemperature() +
                        "\nEnergyConsumption is: " + homeThermostat.getConsumption());
            }
        }

        for (HostDevice device : devices) {
            if (device instanceof SmartSecurityCamera) {
                SmartSecurityCamera parkingCamera = (SmartSecurityCamera) device;
                System.out.println("\nParking Camera Status:");
                parkingCamera.turnOn();
                parkingCamera.getConsumption();
                parkingCamera.setRecording(true);
                System.out.println("The device is: " + parkingCamera.status +
                        "\nEnergy Consumption is: " + parkingCamera.getConsumption() +
                        "\nRecording Status: " + parkingCamera.isRecording());
            }
        }

        /** Calculeaza consumul total al dispozitivelor cand sunt pornite/oprite.
         */
        double totalEnergyConsumption=0;
        for (HostDevice device : devices) {
            if (device instanceof SmartLamp) {
                SmartLamp bedroomLamp = (SmartLamp) device;
                bedroomLamp.setBrightness(70);
            }
            totalEnergyConsumption += device.getConsumption();
        }
        System.out.println("\nTotal Energy Consumption is:" + totalEnergyConsumption);
    }

}
