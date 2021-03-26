package travel.travel_API.SecurityModel;

public class JwtUser {
   private String UserName;
   private Long userId;
   private String role;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public Long getUserId() {
        return userId;
    }



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(long userId) {
        this.userId = userId;
    }
}
