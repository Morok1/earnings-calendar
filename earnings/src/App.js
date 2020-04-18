import React from 'react';
import './App.css';
import TableContainer from "@material-ui/core/TableContainer";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";
import makeStyles from "@material-ui/core/styles/makeStyles";
import Paper from "@material-ui/core/Paper";

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});


class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {data: []};
        // Эта строка важна!

    }

    componentWillMount() {
        fetch("http://localhost:8081/earnings")
            .then(res => res.json())
            .then(res => this.setState({data:res.then(JSON.stringify(res))}))
            .then(res => console.log('re' + JSON.stringify(res)));


        console.log('result' + this.state.data);
    }

    render() {
        return (
            <TableContainer component={Paper}>
                    <Table className={'classes.table'} aria-label="simple table">
                        <TableHead>
                            <TableRow>
                                <TableCell>Data</TableCell>
                                <TableCell align="right">EpsActual</TableCell>
                                <TableCell align="right">EpsEstimate</TableCell>
                                <TableCell align="right">Hour</TableCell>
                                <TableCell align="right">Quarter</TableCell>
                                <TableCell align="right">RevenueActual</TableCell>
                                <TableCell align="right">RevenueEstimate</TableCell>
                                <TableCell align="right">Symbol</TableCell>
                                <TableCell align="right">Year</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {this.state.data.then(rows => rows.map((row) => (
                                <TableRow key={row.data}>
                                    <TableCell component="th" scope="row">
                                        {row.data}
                                    </TableCell>
                                    <TableCell align="right">{row.epsActual}</TableCell>
                                    <TableCell align="right">{row.epsEstimate}</TableCell>
                                    <TableCell align="right">{row.hour}</TableCell>
                                    <TableCell align="right">{row.quarter}</TableCell>
                                    <TableCell align="right">{row.revenueActual}</TableCell>
                                    <TableCell align="right">{row.revenueEstimate}</TableCell>
                                    <TableCell align="right">{row.symbol}</TableCell>
                                    <TableCell align="right">{row.year}</TableCell>
                                </TableRow>)
                            ))}
                        </TableBody>
                    </Table>
                </TableContainer>

        );
    }
}

export default App;
