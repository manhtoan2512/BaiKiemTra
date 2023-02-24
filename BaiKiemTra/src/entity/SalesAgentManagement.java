package entity;

import java.util.Arrays;

public class SalesAgentManagement {

    private SalesAgent salesAgent;
    private SalesAgentManagementDetail[] salesAgentManagementDetails;

    public SalesAgentManagement(SalesAgent salesAgent, SalesAgentManagementDetail[] salesAgentManagementDetails) {
        this.salesAgent = salesAgent;
        this.salesAgentManagementDetails = salesAgentManagementDetails;

    }

    public SalesAgent getSalesAgent() {
        return salesAgent;
    }

    public void setSalesAgent(SalesAgent salesAgent) {
        this.salesAgent = salesAgent;
    }

    public SalesAgentManagementDetail[] getSalesAgentManagementDetails() {
        return salesAgentManagementDetails;
    }

    public void setSalesAgentManagementDetails(SalesAgentManagementDetail[] salesAgentManagementDetails) {
        this.salesAgentManagementDetails = salesAgentManagementDetails;
    }

    @Override
    public String toString() {
        return "SalesAgentManagement{" +
                "salesAgent=" + salesAgent +
                ", salesAgentManagementDetails=" + Arrays.toString(salesAgentManagementDetails) +
                '}';
    }

}
