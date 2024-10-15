import apiClient from "./apiClient";

export const signup = async (registerUser) => {
    try {
        const response = await apiClient.post('/signup', registerUser)
        console.log("Signup response", response);
        return response.data;
        
    } catch (error) {
        throw error;
    }
}

export const signin = async (loginUser) => {

    try {
        const response = await apiClient.post('/signin', loginUser)
        return response.data;
        
    } catch (error) {
        throw error;
    }
}