import apiClient from "./apiClient";

export const addEmployee = async (employeeData) => {
    try {
        const response = await apiClient.post('/addEmployee', employeeData);
        return response;
    } catch (error) {
        console.log(error);
        
    }
}