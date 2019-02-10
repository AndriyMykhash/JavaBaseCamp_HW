package homework;

public class TreadedBug extends Thread {
    int number = 0;

    public TreadedBug(int number){
        this.number = number;
    }

    @Override
    public void run() {
        double sum = 0;

        for(int i = 0; i < 100; i++){
            try {
                Thread.sleep(50);
            }
            catch (Exception e){
                continue;
            }

            if (sum < 5) {
                sum += (Math.random()*2) - 0.5;
                System.out.println(number + "  - bug on: "+ sum);
            }
            else{
                showStatus();
                break;
            }
        }

    }

    private void showStatus(){
        try {
            Thread.sleep(1000);
        }
        catch (Exception e){
        }
        System.out.println("\nBug number: " + number + ", with name: " + getName() + " has finished =)\n");
    }
}
