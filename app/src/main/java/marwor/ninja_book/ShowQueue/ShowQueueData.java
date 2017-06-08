package marwor.ninja_book.ShowQueue;


public class ShowQueueData {
    private String title;
    private String inscription;
    private String placeInQueue;

    public ShowQueueData(String title,int placeInQueue){
        this.title=title;
        this.inscription="Twoje miejsce w kolejce ";
        this.placeInQueue=Integer.toString(placeInQueue);

    }
    public String setTitle(){
        return title;
    }
    public String setPlace(){
        return inscription+placeInQueue;
    }
}
