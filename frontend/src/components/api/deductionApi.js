import apiClient from "./apiClient";

export const addDeductions = async (deductionData) => {
    try {
        const response = await apiClient.post("/addDeduction", deductionData);
        return response;
    } catch (error) {
        throw error;
    }
}

export const getDeduction = async (employeeId) => {
    try {
        const response = await apiClient.get(`/deductions/${employeeId}`);
        return response;
    } catch (error) {
        throw error;
    }
}

export const deleteDeduction = async (deductionId) => {
    try {
        const response = await apiClient.delete(`/deduction/${deductionId}`);
        return response;
    } catch (error) {
        throw error;
    }
}