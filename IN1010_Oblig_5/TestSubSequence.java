public class TestSubSequence {

    public static void main(String[] args) {
        testNokkel();
        testAntallOgLeggTil();
    }

    public static void testNokkel(){
        SubSequence sub = new SubSequence("ABC");
        // forventet, faktisk
        assert("ABC" == sub.nokkel());
    }

    public static void testAntallOgLeggTil(){
        SubSequence sub = new SubSequence("ABC");
        assert(1 == sub.antall());
        sub.leggTil(3);
        assert(4 == sub.antall());
    }
}
