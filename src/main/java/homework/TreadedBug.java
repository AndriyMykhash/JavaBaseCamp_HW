package homework;

public class TreadedBug extends Thread {
    int number = 0;

    public TreadedBug(){
    }

    public TreadedBug(int number){
        this.number = number+1;
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
            }
            else{
                try{
                    showStatus();
                }
                catch (NuShoPorobyshException e) {
                    System.out.println("Vse pohano");
                }
                break;
            }
        }

    }

    private void showStatus() throws NuShoPorobyshException {
        try {
            Thread.sleep(1000);
        }
        catch (NuShoPorobyshException e){
            throw new NuShoPorobyshException("Do not use \'sleep()\'");
        }
        catch (Exception e){

        }

        if(number != 0)
            System.out.println("\nBug number: " + number + ", with name: " + getName() + " has finished =)\n");
        else
            System.out.println("\nBug name: " + getName() + " has finished =)\n");

    }
}

class NuShoPorobyshException extends  InterruptedException{

    NuShoPorobyshException(String message){
        super(message);
    }

}