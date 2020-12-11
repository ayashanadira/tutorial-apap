import React, { Component } from "react";
import Hotel from "../../components/Hotel";
import Button from "../../components/Button";
import Modal from "../../components/Modal";
import APIConfig from "../../api/APIConfig";
import ReactPaginate from 'react-paginate';
import {classes} from "istanbul-lib-coverage";

class HotelList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            hotels: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            textFilter: "",
            namaHotel: "",
            alamat: "",
            nomorTelepon: ""
            offset: 0,
            perPage: 5,
            currentPage: 0,
        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddHotel = this.handleAddHotel.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitAddHotel = this.handleSubmitAddHotel.bind(this);
        this.handleEditHotel = this.handleEditHotel.bind(this);
        this.handleSubmitEditHotel = this.handleSubmitEditHotel.bind(this);this.handleDeleteHotel = this.handleDeleteHotel.bind(this);
        this.handlePaginate = this.handlePaginate.bind(this);
        this.handleChangeFieldFilter = this.handleChangeFieldFilter.bind(this);

    }

    componentDidMount() {
        this.loadData();
    }
    
    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }
    
    handleAddHotel() {
        this.setState({ isCreate: true });
    }
    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate: false, isEdit: false });
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }
  
    async loadData() {
        try{
        await APIConfig.get("/hotels")
            .then(from_api => {
                const data = from_api.data;
                const data2 = data.filter(h => h.namaHotel.includes(this.state.textFilter)).map((hotel) =>
                    <Hotel
                        key={hotel.id}
                        listKamar={hotel.listKamar}
                        id={hotel.id}
                        namaHotel={hotel.namaHotel}
                        alamat={hotel.alamat}
                        nomorTelepon={hotel.nomorTelepon}
                        handleEdit={() => this.handleEditHotel(hotel)}
                        handleDelete={() => this.handleDeleteHotel(hotel.id)}
                    />
                )
                const postData = data2.slice(this.state.offset, this.state.offset + this.state.perPage);
                this.setState({
                    pageCount: Math.ceil(data.length / this.state.perPage),
                    postData
                })
            });
        }
        catch (error){
                alert("Oops terjadi masalah pada server");
                console.log(error);
            }
    }

    async handleSubmitAddHotel(event) {
        event.preventDefault();
        try {
            const data = {
                namaHotel: this.state.namaHotel,
                alamat: this.state.alamat,
                nomorTelepon: this.state.nomorTelepon,
            };
            await APIConfig.post("/hotel", data);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleAddHotel() {
        this.setState({ isCreate: true });
    }

    handleEditHotel(hotel) {
        this.setState({
            isEdit: true,
            id: hotel.id,
            namaHotel: hotel.namaHotel,
            alamat: hotel.alamat,
            nomorTelepon: hotel.nomorTelepon,
        });
    }

    async handleSubmitEditHotel(event) {
        event.preventDefault();
        try {
            const data = {
                namaHotel: this.state.namaHotel,
                alamat: this.state.alamat,
                nomorTelepon: this.state.nomorTelepon,
            };
            await APIConfig.put(`/hotel/${this.state.id}`, data);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleDeleteHotel(id) {
        try {
            await APIConfig.delete(`/hotel/${id}`);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    handlePaginate = (e) => {
        const selectedPage = e.selected;
        const offset = selectedPage * this.state.perPage;

        this.setState({
            currentPage: selectedPage,
            offset: offset
        }, () => {
            this.loadData()
        });

    };

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleChangeFieldFilter(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
        this.loadData();
    }

    render() {
        console.log("render()");
        return (
            <div className={classes.hotelList}>
                <h1 className={classes.title}>All Hotels</h1>
                <Button onClick={this.handleAddHotel} variant="primary">
                    Add Hotel
                </Button>
                <h4>Cari Hotel</h4>
                <input
                    className={classes.textField}
                    type="text"
                    placeholder="Cari Hotel"
                    name="textFilter"
                    value={this.state.textFilter}
                    onChange={this.handleChangeFieldFilter}
                />
                <div>
                {/* {this.state.hotels.map((hotel) =>(
                        <Hotel
                        key={hotel.id}
                        id={hotel.id}
                        listKamar={hotel.listKamar}
                        namaHotel={hotel.namaHotel}
                        alamat={hotel.alamat}
                        nomorTelepon={hotel.nomorTelepon}
                        handleEdit={() => this.handleEditHotel(hotel)}
                        handleDelete={() => this.handleDeleteHotel(hotel.id)}
                        />
                    ))} */}

                    {this.state.postData}
                    <br/>
                    <ReactPaginate
                        previousLabel={"prev"}
                        nextLabel={"next"}
                        breakLabel={"..."}
                        breakClassName={"break-me"}
                        pageCount={this.state.pageCount}
                        marginPagesDisplayed={2}
                        pageRangeDisplayed={5}
                        onPageChange={this.handlePaginate}
                        containerClassName={classes.pagination}
                        subContainerClassName={classes.pagination, classes.page}
                        activeClassName={classes.active}/>
                </div>
                <Modal
                    show={this.state.isCreate || this.state.isEdit}
                    handleCloseModal={this.handleCancel}
                >
                    <form>
                        <h3 className={classes.modalTitle}>
                            {this.state.isCreate
                                ? "Add Hotel"
                                : `Edit Hotel Nomor ${this.state.id}`}
                        </h3>
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Nama Hotel"
                            name="namaHotel"
                            value={this.state.namaHotel}
                            onChange={this.handleChangeField}
                        />
                        <br/>
                        <input
                            className={classes.textField}
                            type="text"
                            placeholder="Alamat"
                            name="alamat"
                            value={this.state.alamat}
                            onChange={this.handleChangeField}
                        />
                        <br/>
                        <textarea
                            className={classes.textField}
                            placeholder="Nomor Telepon"
                            name="nomorTelepon"
                            rows="4"
                            value={this.state.nomorTelepon}
                            onChange={this.handleChangeField}
                        />
                        <br/>
                        <Button
                            onClick={
                                this.state.isCreate
                                    ? this.handleSubmitAddHotel
                                    : this.handleSubmitEditHotel
                            }
                            variant="primary"
                        >
                            {this.state.isCreate ? "Create" : "Edit"}
                        </Button>
                        <Button onClick={this.handleCancel} variant="danger">
                            Cancel
                        </Button>
                    </form>
                </Modal>
            </div>
        );
    }
}

export default HotelList;