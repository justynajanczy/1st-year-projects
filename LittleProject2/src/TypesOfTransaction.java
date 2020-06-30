public enum TypesOfTransaction {
    INIT_DEPOS
            {
                @Override
                public String toString()
                {
                    return "Init depos";
                }
            },
    DEPOSIT
            {
                 @Override
                public String toString()
                {
                    return "Deposit";
                }
        },
    WITHDRAWAL
            {
                @Override
                public String toString()
                {
                    return "Withdrawal";
                }
            },
    TRANS_FROM
            {
                @Override
                public String toString()
                {
                    return "Trans. from";
                }
            },
    TRANS_TO
            {
                @Override
                public String toString() {
                    return "Trans. to";
                }
            };
}
