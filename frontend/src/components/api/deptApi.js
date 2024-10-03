import apiClient from "./apiClient";

export const fetchAllDept = async () => {
    try {
        const response = await apiClient.get('/departments');
        console.log("All Dept", response);
        return response;
        
    } catch (error) {
        
    }
}

