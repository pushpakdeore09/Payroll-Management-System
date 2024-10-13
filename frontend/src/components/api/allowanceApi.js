import apiClient from "./apiClient";

export const addAllowance = async (allowanceData) =>{
    try {
        const response = await apiClient.post("/addAllowance", allowanceData);
        return response;
    } catch (error) {
        throw error;
    }
}

export const getAllowance = async (employeeId) =>{
    try {
        const response = await apiClient.get(`/allowances/${employeeId}`);
        return response;
    } catch (error) {
        throw error;
    }
}