package pl.dpotyralski;

class TimeoutPossibleResource {
    public int calculateImpact(int elements) {
        try {
            Thread.sleep(1000 * elements);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return elements * 2;
    }

    public String getValue() throws InterruptedException {
        Thread.sleep(2500);
        return "lateValue";
    }
}
