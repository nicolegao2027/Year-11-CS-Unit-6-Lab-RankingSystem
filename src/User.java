public class User{
    private int rank;
    private int progress;
    public User() {
        this.rank=-8;
        this.progress=0;
    }
    public int getRank() {
        return rank;
    }
    public int getProgress() {
        return progress;
    }
    public void incProgress(int activityRank){
        if (activityRank==0||activityRank<-8||activityRank>8) {
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        int rankDiff=0;
        if((rank<0&&activityRank<0)||(rank>0&&activityRank>0)){
            rankDiff=rank-activityRank;
        }
        else{
            if(rank>activityRank){
                rankDiff=rank-activityRank-1;
            }
            else if(rank<activityRank){
                rankDiff=rank-activityRank+1;
            }
        }
        if(rankDiff==0){
            progress+=3;
            updateRank();
        }
        else if(rankDiff==1){
            progress+=1;
            updateRank();
        }
        else if(rankDiff<0){
            progress+=10*rankDiff*rankDiff;
            updateRank();
        }
    }
    private void updateRank(){
        int n=progress/100;
        while(n>0){
            if(progress>=100&&rank<=8){
                rank=nextRank(rank);
                progress-=100;
            }
            n--;
        }
    }
    private int nextRank(int currentRank) {
        int nextRank=currentRank+1;
        if(nextRank==0){
            nextRank+=1;
            return nextRank;
        }
        if(nextRank<8&&nextRank>-8){
            return nextRank;
        }
        else{
            return currentRank;
        }
    }
    public String toString(){
        return "User{rank="+ this.getRank()+", progress="+this.getProgress()+"}";
    }

}
