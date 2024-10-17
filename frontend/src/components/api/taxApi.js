import apiClient from "./apiClient";

export const addTax =  async (taxData) => {
    try {
        const response = await apiClient.post("/addTax", taxData);
        return response;
    } catch (error) {
        throw error;
    }
}