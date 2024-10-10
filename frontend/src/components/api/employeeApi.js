import apiClient from "./apiClient";

export const addEmployee = async (employeeData) => {
    try {
        const response = await apiClient.post('/addEmployee', employeeData);
        return response;
    } catch (error) {
        throw error;
        
    }
}

export const searchEmployee = async (employeeId) => {
    try {
        const response = await apiClient.get(`/employee/${employeeId}`)
        
        return response.data;
    } catch (error) {
        throw error;
    }
}

export const updateEmployee = async (updatedData) => {
    console.log(updatedData);
    try {
        const response = await apiClient.put('/employee', updatedData);
        return response.data;
    } catch (error) {
        throw error;
    }
}

export const getAllEmployees = async () => {
    try {
        const response = await apiClient.get('/employees');
        return response;
    } catch (error) {
        throw error;
    }
}