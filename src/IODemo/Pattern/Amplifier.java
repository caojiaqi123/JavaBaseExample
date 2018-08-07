package IODemo.Pattern;

public class Amplifier {
    private Voice voice;

    public Amplifier(Voice voice) {
        super();
        this.voice = voice;
    }

    public Amplifier() {
    }

    public void say() {
        System.out.println(voice.getVoice() * 100);
    }
}
