import axios from 'axios';

const apiClient = axios.create({
    baseURL: "http://localhost:8080/"
})

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
        console.log("Signin response", response);
        return response.data;
        
    } catch (error) {
        throw error;
    }
}