package com.crowdscout.dto;

public class ScoutLoginResponseDTO{

    private int response;
    private String message;

    public ScoutLoginResponseDTO(int response, String message) {
        this.response = response;
        this.message = message;
    }

    public static ScoutLoginResponseDTO getDefault(){
        return new ScoutLoginResponseDTO(403, "Login was unsuccesful.");
    }

    /**
     * @return the response
     */
    public int getResponse() {
        return response;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(int response) {
        this.response = response;
    }
}