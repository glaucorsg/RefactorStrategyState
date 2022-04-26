package br.edu.ifpb.foodstore.domain.state;

public enum OrderEnum implements OrderState {
    IN_PROGRESS {
        @Override
        public String cancel() {
            return "Canceling in progress order";
        }
    }
    ,CANCELED {
        @Override
        public String cancel() {
            return "Order already canceled!";
        }
    }
    ,PAYMENT_SUCCESS {
        @Override
        public String cancel() {
            return "Canceling already paid order";
        }
    }
    ,PAYMENT_REFUSED {
        @Override
        public String cancel() {
            return "Canceling refused order";
        }
    }

}
