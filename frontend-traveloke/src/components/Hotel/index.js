import React from "react";
import classes from "./styles.module.css";
import Button from "../Button";
import Kamar from "../Kamar";

const Hotel= (props) => {
    const { id, namaHotel, alamat, nomorTelepon, listKamar, handleEdit, handleDelete } = props;
    return (
        <div className={classes.hotel}>
            <h3>{`ID Hotel ${id}`}</h3>
            <p>{`Nama Hotel: ${namaHotel}`}</p>
            <p>{`Alamat: ${alamat}`}</p>
            <p>{`Nomor Telepon: ${nomorTelepon}`}</p>

            <div>
                {listKamar.map((kamar) => (
                    <div className={classes.btn}>

                        <Kamar
                            namaKamar={kamar.namaKamar}
                            kapasitas={kamar.kapasitasKamar}
                        />
                    </div>
                ))}
            </div>
            <div>
                {listKamar == 0 ? <h4>Belum ada kamar</h4> : null}
            </div>
            <br></br>

            <Button onClick={handleEdit} variant="success">
                Edit
            </Button>
            <Button onClick={handleDelete} variant="danger">
                Delete
            </Button>
        </div>
    );
};

export default Hotel;
