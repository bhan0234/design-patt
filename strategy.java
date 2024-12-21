// Strategy Interfaces
interface Device {
    void device();
}

interface Resolution {
    void resolution();
}

// Concrete Strategies for Device
class TV implements Device {
    @Override
    public void device() {
        System.out.println("Playing video on TV");
    }
}

class Phone implements Device {
    @Override
    public void device() {
        System.out.println("Playing video on Phone");
    }
}

// Concrete Strategies for Resolution
class Resol1080p implements Resolution {
    @Override
    public void resolution() {
        System.out.println("Playing in 1080p");
    }
}

class Resol480p implements Resolution {
    @Override
    public void resolution() {
        System.out.println("Playing in 480p");
    }
}

// Context Class
class VideoPlayer {
    private Device device;
    private Resolution resolution;

    public VideoPlayer(Device device, Resolution resolution) {
        this.device = device;
        this.resolution = resolution;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public void display() {
        device.device();
        resolution.resolution();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        // Example 1: Play video on TV in 1080p
        Device tv = new TV();
        Resolution hd = new Resol1080p();
        VideoPlayer videoPlayer = new VideoPlayer(tv, hd);
        videoPlayer.display();

        // Example 2: Change to Phone and 480p
        Device phone = new Phone();
        Resolution sd = new Resol480p();
        videoPlayer.setDevice(phone);
        videoPlayer.setResolution(sd);
        videoPlayer.display();
    }
}
