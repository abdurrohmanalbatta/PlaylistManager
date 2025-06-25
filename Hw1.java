
// Name Surname: Abdurahmon Anvar Ugli Abdurakhimov
// Student ID  : 23050141008 
// Video Link  : https://drive.google.com/file/d/16uaD2sS6iSkPFrp_OCwP0-w2ykMfVKvQ/view?usp=sharing
 
/* 
 I create Song class with next and previous. In the SinglyLinkedList(only have Song head)
I only use Song's next and fully working addSong, removeSong and displayPlaylist. 

In the DoublyLinkedList(head,currentSong and number of song) I use Song's next and previous.
There are fully working addSong, removeSong, displayPlaylist, moveSong, playNext, playPrevious functions and
extra addSongFront, addSongEnd, addSongToNewPosition, removeSong(which get object not a title), searchSong

I try to cover all edge cases.
 

*/


class Song{
    String title;
    String artist;
    int duration;
    Song next,prev;
    
    
    public Song(String title, String artist, int duration){
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    
    @Override
    public String toString(){
        return title + " (" + artist + ") " + duration + " s";
    }
}
class SinglyLinkedList { 
    Song head;
    
    
    public void addSong(String title, String artist, int duration){
        Song newSong = new Song(title, artist, duration);
        if(head != null){
            Song temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newSong;
        }else{
            head = newSong;
        }
    }
    
    public void removeSong(String title){
        if(head != null){                        //checking playlist is empty or not.
            if(head.title.equals(title)){ //if song is in the beginning 
                head = head.next;
                System.out.println("\n\"" + title + "\" song is removed from playlist.");
                return;
            }
            Song temp = head, prev = null;
            while(temp != null){
                if(temp.title.equals(title)){ //if song is in the middle or end
                    prev.next = temp.next;
                    System.out.println("\n\"" + title + "\" song is removed from playlist.");
                    return;
                }else{
                    prev = temp;
                    temp = temp.next;
                }
            }
            System.out.println("\n\"" + title + "\" song is not found in the playlist. You can not remove it !!!" );
            
        }else{
            System.out.println("\nPlaylist is empty !!! You can not remove \"" + title + "\" song. Please add song to playlist firstly.");
        }
        
    }
    
    public void displayPlaylist(){
        if(head != null){
            System.out.println("\nPlaylist:");
            Song temp = head;
            for (int i = 1; temp != null; i++) {
                System.out.println(i + ". " + temp);
                temp = temp.next;
            }
        }else{
            System.out.println("\nPlaylist is empty !!! ");
        }
    }    
    
    
    public void moveSong(String title, int Newpos){
        System.out.println("\nThis feature for only DoublyLinkedList.");
    }
    public void playNext(){
        System.out.println("\nThis feature for only DoublyLinkedList.");
    }
    public void playPrevious(){
        System.out.println("\nThis feature for only DoublyLinkedList.");
    }
    
    
} 

class DoublyLinkedList{
    Song head, currentSong;
    int numberOfSong;
    
    public void addSong(String title, String artist, int duration){
        Song newSong = new Song(title, artist, duration);
        if(head != null){
            addSongEnd(newSong);
            numberOfSong ++;
        }else{
            head = newSong;
            numberOfSong = 1;
        }
    }
    
    public void addSongFront(Song song){
        song.next = head;
        song.prev = null;
        head.prev = song;
        head = song;
    }
    
    public void addSongEnd(Song song){
        Song temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = song;
        song.prev = temp;
        song.next = null;
    }
    public void addSongToNewPosition(Song song,int newPos){
        Song temp = head;
        int counter = 1;

        while (temp.next != null && counter != newPos - 1) {
            temp = temp.next;
            counter++;
        }

        temp.next.prev = song;
        song.next = temp.next;
        temp.next = song;
        song.prev = temp;
        
    }
    
    
    public void removeSong(String title){         //this remove gets TITLE
        if(head != null){                        //checking playlist is empty or not.
            if(head.title.equals(title)){ //if song is in the beginning 
                if(head.next != null){           //checking if there are more than one song.
                    head = head.next;
                    head.prev = null;
                    System.out.println("\n\"" + title + "\" song is removed from playlist.");
                    return;
                }else{                           //if there is one song only.
                    head = null;
                    System.out.println("\n\"" + title + "\" song is removed from playlist. And playlist is empty now !!!");
                    return;
                }
            }
            Song temp = head;
            while(temp != null){
                if(temp.title.equals(title)){ //if song is in the middle or end
                    temp.prev.next = temp.next;
                    if(temp.next != null){
                        temp.next.prev = temp.prev;
                    }
                    System.out.println("\n\"" + title + "\" song is removed from playlist.");
                    return;
                }else{
                    temp = temp.next;
                }
            }
            System.out.println("\n\"" + title + "\" song is not found in the playlist. You can not remove it !!!" );
            
        }else{
            System.out.println("\nPlaylist is empty !!! You can not remove \"" + title + "\" song. Please add song to playlist firstly.");
        }
    }
    
    public void removeSong(Song song){           //this remove gets OBJECT
        if(head != null){                        //checking playlist is empty or not.
            if(head.title.equals(song.title)){ //if song is in the beginning 
                if(head.next != null){           //checking if there are more than one song.
                    head = head.next;
                    head.prev = null;
                    return;
                }else{                           //if there is one song only.
                    head = null;
                    return;
                }
            }
            Song temp = head;
            while(temp != null){
                if(temp.title.equals(song.title)){ //if song is in the middle or end
                    temp.prev.next = temp.next;
                    if(temp.next != null){
                        temp.next.prev = temp.prev;
                    }
                    return;
                }else{
                    temp = temp.next;
                }
            }
            
        }
    }
    
    
    public void displayPlaylist(){
        if(head != null){
            System.out.println("\nPlaylist:");
            Song temp = head;
            for (int i = 1; temp != null; i++) {
                System.out.println(i + ". " + temp);
                temp = temp.next;
            }
            System.out.println("number of song: " + numberOfSong);
        }else{
            System.out.println("\nPlaylist is empty !!! ");
        }
    }

    public Song searchSong(String title){
        if(head == null){
            System.out.println("\nPlaylist is empty !!!");
            return null;
        }        
        Song temp = head;
        while(!temp.title.equals(title)){
            if (temp.next != null)
                temp = temp.next;
            else
               return null;
        }
        return temp;
        
    }
    
    public void moveSong(String title, int newPos){
        Song song = searchSong(title);
        if(song == null){
            System.out.println("\n\"" + title + "\" song is not found !!!");
            return;
        }
        if(!(0 > newPos) && !(newPos <= numberOfSong) ){
            System.out.println("\nPosition is not valid !!!");
            return;
        }
        
        if(newPos == 1){    
            if(head.next != null){
                removeSong(song);
                addSongFront(song);
                System.out.println("\n\"" + song.title + "\" song moved to first position");
            }else{
                System.out.println("\n\"" + song.title + "\" song is already in the first position, you don't need to move it." );
            }
        }else if(newPos == numberOfSong){
            removeSong(song);
            addSongEnd(song);
            System.out.println("\n\"" + song.title + "\" song moved to " + newPos +"-position");
        }else{
            removeSong(song);
            addSongToNewPosition(song,newPos);
            System.out.println("\n\"" + song.title + "\" song moved to " + newPos +" - position");
        }
        
        
        
        
    }
    
    public void playNext(){
        if(head == null){
            System.out.println("\nPlaylist is empty !!!");
            return;
        }
        if(currentSong == null){
            currentSong = head;
            System.out.println("\nPlaylist is beginning, \"" + currentSong.title +"\" song is playing now. " );
            return;
        }
        if(currentSong.next != null){
            currentSong = currentSong.next;
            System.out.println("\n\"" + currentSong.title + "\" song is playing. ");
        }else{
            System.out.println("\nThere is no next song.");
        }
        
    }
    
    public void playPrevious(){
        if(head == null){
            System.out.println("\nPlaylist is empty");
            return;
        }
        if(currentSong == null){
            System.out.println("\nThere is no previous song. If you want to begin Playlist please press \"5. Play Next Sonng\" . ");
            return;
        }
        if(currentSong.prev != null){
            currentSong = currentSong.prev;
            System.out.println("\n\"" + currentSong.title + "\" song is playing. ");
        }else{
            System.out.println("\nThere is no previous song. ");
        }
    }
}
