import apiClient from "./apiClient";

export const addDeductions = async (deductionData) => {
    try {
        const response = await apiClient.post("/addDeduction", deductionData);
        return response;
    } catch (error) {
        throw error;
    }
}