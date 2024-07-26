public interface Uploader {
    public void addFollower(User follower); // 增加关注

    public void notifyFollowers(int hit); // 通知所有关注用户

    public void addMoney(Long money);
}
