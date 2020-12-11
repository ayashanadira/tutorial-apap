import React from "react";
import Button from "../Button";

const Kamar = (props) => {
    const { namaKamar, kapasitas } = props;
    return (
        <div>
            <Button variant="primary">{`${namaKamar} (${kapasitas})`}</Button>
        </div>
    );
};

export default Kamar;
